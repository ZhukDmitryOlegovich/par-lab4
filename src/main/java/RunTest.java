import akka.actor.AbstractActor;
import jdk.internal.net.http.common.Pair;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class ActorTester extends AbstractActor {
    private static final String SCRIPT_ENGINE_NAME = "nashorn";

    static public Pair<Boolean, String> execJS(
            String jscript, String functionName, Object[] params
    ) throws ScriptException, NoSuchMethodException {
        try {
            ScriptEngine engine = new ScriptEngineManager().getEngineByName(SCRIPT_ENGINE_NAME);
            engine.eval(jscript);
            return new Pair<>((Invocable) engine).invokeFunction(functionName, params).toString();
        } catch () {
            
        }

    }

    public ResultTest runTest(InputTest inputTest) {

    }
}
