import akka.actor.AbstractActor;

import java.util.*;

public class StorageTests extends AbstractActor {
    private final Map<String, List<ResultTest>> storage = new HashMap<>();

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
        Objects.requireNonNull(storage.containsKey(wrapResultTest.packageId)
                ? storage.get(wrapResultTest.packageId)
                : storage.put(wrapResultTest.packageId, new ArrayList<>())
        ).add(wrapResultTest.resultTest);
    }

    private WrapResultTestList get(String packageId) {
        return new WrapResultTestList(packageId, packageID, jsscript, funcName, storage.get(packageId));
    }
}
