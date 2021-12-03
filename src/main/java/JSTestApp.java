import akka.actor.ActorSystem;
import akka.http.javadsl.server.AllDirectives;

public class JSTestApp extends AllDirectives {
    public static void main(String[] args) {
        ActorSystem actorSystem = ActorSystem.create("js_test_app");
    }
}
