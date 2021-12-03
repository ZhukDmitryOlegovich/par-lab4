import akka.NotUsed;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.http.javadsl.ConnectHttp;
import akka.http.javadsl.Http;
import akka.http.javadsl.ServerBinding;
import akka.http.javadsl.marshallers.jackson.Jackson;
import akka.http.javadsl.model.HttpRequest;
import akka.http.javadsl.model.HttpResponse;
import akka.http.javadsl.server.AllDirectives;
import akka.http.javadsl.server.Route;
import akka.pattern.Patterns;
import akka.stream.ActorMaterializer;
import akka.stream.javadsl.Flow;

import java.io.IOException;
import java.util.concurrent.CompletionStage;

import scala.concurrent.Future;

public class JSTestApp extends AllDirectives {
    public static void main(String[] args) throws IOException {
        ActorSystem actorSystem = ActorSystem.create("js_test_app");
        ActorRef actorRef = actorSystem.actorOf(Props.create(RouterTests.class));

        final Http http = Http.get(actorSystem);
        final ActorMaterializer materializer = ActorMaterializer.create(actorSystem);
        JSTestApp instance = new JSTestApp();
        final Flow<HttpRequest, HttpResponse, NotUsed> responseNotUsedFlow =
                instance.createRoute(actorRef).flow(actorSystem, materializer);
        final CompletionStage<ServerBinding> bindingCompletionStage = http.bindAndHandle(
                responseNotUsedFlow,
                ConnectHttp.toHost("localhost", 8080),
                materializer
        );
        System.out.println("Server online at http://localhost:8080/\nPress RETURN to stop...");
        System.in.read();
        bindingCompletionStage
                .thenCompose(ServerBinding::unbind)
                .thenAccept(unbound -> actorSystem.terminate());
    }

    private Route createRoute(ActorRef actorRouter) {
        return route(
                path("test", () -> route(post(() -> entity(
                        Jackson.unmarshaller(WrapInputTestList.class),
                        wrapInputTestList -> {
                            actorRouter.tell(wrapInputTestList, ActorRef.noSender());
                            return complete("Test started!");
                        }
                )))),
                path("result", () -> route(get(() -> parameter("packageId", (packageId) -> {
                    Future<Object> result = Patterns.ask(
                            actorRouter,
                            packageId,
                            5000
                    );
                    return completeOKWithFuture(result, Jackson.marshaller());
                }))))
        );
    }
}
