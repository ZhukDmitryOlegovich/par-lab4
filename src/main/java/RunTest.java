import akka.actor.AbstractActor;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class ActorTester extends AbstractActor {
    private static final String SCRIPT_ENGINE_NAME = "nashorn";

    static private String execJS(
            String jscript, String functionName, Object[] params
    ) throws ScriptException, NoSuchMethodException {
            ScriptEngine engine = new ScriptEngineManager().getEngineByName(SCRIPT_ENGINE_NAME);
            engine.eval(jscript);
            return ((Invocable) engine).invokeFunction(functionName, params).toString();
    }

    public ResultTest runTest(String jscript, String functionName, InputTest inputTest) {
        try {
            return new ResultTest(inputTest, execJS(jscript, functionName, inputTest.params), false);
        } catch (ScriptException | NoSuchMethodException e) {
            return new ResultTest(inputTest, null, true);
        }
    }
}
