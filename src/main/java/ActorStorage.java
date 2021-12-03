import akka.actor.AbstractActor;

import java.util.List;
import java.util.Map;

public class ActorStorage extends AbstractActor {
    private final Map<String, List<ResultTest>> storage;

    public ActorStorage(Map<String, List<ResultTest>> storage) {
        this.storage = storage;
    }

    private void setResult() {

    }
}
