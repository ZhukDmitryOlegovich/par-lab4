import akka.NotUsed;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.http.javadsl.Http;
import akka.http.javadsl.model.HttpRequest;
import akka.http.javadsl.model.HttpResponse;
import akka.http.javadsl.server.AllDirectives;
import akka.stream.ActorMaterializer;
import akka.stream.javadsl.Flow;

public class JSTestApp extends AllDirectives {
    public static void main(String[] args) {
        ActorSystem actorSystem = ActorSystem.create("js_test_app");
        ActorRef actorRef = actorSystem.actorOf(Props.create(RouterTests.class));

        final Http http = Http.get(actorSystem);
        final ActorMaterializer materializer = ActorMaterializer.create(actorSystem);
        JSTestApp instance = new JSTestApp();
        final Flow<HttpRequest, HttpResponse, NotUsed> responseNotUsedFlow =
                instance.
    }
}
