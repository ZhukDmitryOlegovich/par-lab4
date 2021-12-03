import akka.actor.AbstractActor;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class ActorTester extends AbstractActor {
    private static final String SCRIPT_ENGINE_NAME = "nashorn";

    static public ResultExec execJS(
            String jscript, String functionName, Object[] params
    ) {
        try {
            ScriptEngine engine = new ScriptEngineManager().getEngineByName(SCRIPT_ENGINE_NAME);
            engine.eval(jscript);
            return new ResultExec(
                    true,
                    ((Invocable) engine).invokeFunction(functionName, params).toString()
            );
        } catch (ScriptException | NoSuchMethodException e) {
            return new ResultExec(false, null);
        }
    }

    public ResultTest runTest(String jscript, String functionName, InputTest inputTest) {
        ResultExec result = execJS(jscript, functionName, inputTest.params);
        return new ResultTest(inputTest, result.result, !result.first);
    }

    static class ResultExec {
        public final boolean correct;
        public final String result;

        public ResultExec(boolean correct, String result) {
            this.correct = correct;
            this.result = result;
        }
    }
}
