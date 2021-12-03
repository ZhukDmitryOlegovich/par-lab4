import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.routing.ActorRefRoutee;
import akka.routing.RoundRobinRoutingLogic;
import akka.routing.Routee;
import akka.routing.Router;

import java.util.ArrayList;
import java.util.List;

public class RouterTests extends AbstractActor {
    private static final int TESTERS_AMOUNT = 5;

    private final ActorRef actorStorageTests;
    private final Router routerTesters;

    {
        actorStorageTests = getContext().actorOf(Props.create(StorageTests.class));
        List<Routee> routeeList = new ArrayList<>(TESTERS_AMOUNT);
        for (int i = 0; i < TESTERS_AMOUNT; i++) {
            ActorRef r = getContext().actorOf(Props.create(Tester.class));
            getContext().watch(r);
            routeeList.add(new ActorRefRoutee(r));
        }
        routerTesters = new Router(new RoundRobinRoutingLogic(), routeeList);
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(
                        WrapInputTestList.class,
                        wrapInputTestList -> {
                            for ()
                        }
                );
    }
}
