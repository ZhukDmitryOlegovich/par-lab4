import akka.actor.AbstractActor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActorStorage extends AbstractActor {
    private final Map<String, List<ResultTest>> storage = new HashMap<>();

    public void add(String id, ResultTest resultTest) {
        (storage.containsKey(id)
                ? storage.get(id)
                : storage.put(id, new ArrayList<>())
        ).add(resultTest);
    }

    public List<ResultTest> get(String id) {
        return storage.get(id);
    }
}
