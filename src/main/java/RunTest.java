import akka.actor.AbstractActor;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class ActorTester extends AbstractActor {
    private static final String SCRIPT_ENGINE_NAME = "nashorn";

    static public String execJS(
            String jscript, String functionName, Object[] params
    ) throws ScriptException, NoSuchMethodException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName(SCRIPT_ENGINE_NAME);
        engine.eval(jscript);
        return ((Invocable) engine).invokeFunction(functionName, params).toString();
    }

    public runTest(InputTest inputTest) {

    }
}
