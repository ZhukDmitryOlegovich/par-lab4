import akka.actor.AbstractActor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActorStorage extends AbstractActor {
    private final Map<String, List<ResultTest>> storage = new HashMap<>();

    private void setResult(String id, ResultTest resultTest) {
        storage.get(id)
    }
}
