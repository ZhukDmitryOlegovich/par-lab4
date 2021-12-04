import akka.actor.AbstractActor;

import java.util.*;

public class StorageTests extends AbstractActor {
    private final Map<String, ArrayList<ResultTest>> storage = new HashMap<>();

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(
                        WrapResultTest.class,
                        this::add
                )
                .match(
                        String.class,
                        packageId -> sender().tell(
                                this.get(packageId),
                                self()
                        )
                )
                .build();
    }

    private void add(WrapResultTest wrapResultTest) {
        storage.computeIfAbsent(wrapResultTest.packageId, k -> new ArrayList<>()).add(wrapResultTest.resultTest);
    }

    private WrapResultTestList get(String packageId) {
        return new WrapResultTestList(packageId, storage.get(packageId));
    }
}
