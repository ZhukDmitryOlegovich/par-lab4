import akka.actor.AbstractActor;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Tester extends AbstractActor {
    private static final String SCRIPT_ENGINE_NAME = "nashorn";

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(
                        WrapInputTest.class,
                        wrapInputTest -> sender().tell(
                                runTest(wrapInputTest),
                                self()
                        )
                )
                .build();
    }

    static private String execJS(
            String jsScript, String functionName, Object[] params
    ) throws ScriptException, NoSuchMethodException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName(SCRIPT_ENGINE_NAME);
        engine.eval(jsScript);
        return ((Invocable) engine).invokeFunction(functionName, params).toString();
    }

    public WrapResultTest runTest(WrapInputTest wrapInputTest) {
        try {
            return new WrapResultTest(
                    wrapInputTest.packageId,
                    new ResultTest(
                            wrapInputTest.inputTest.testName,
                            wrapInputTest.inputTest.expectedResult,
                            execJS(wrapInputTest.jsScript, wrapInputTest.functionName, wrapInputTest.inputTest.params),
                            false
                    )
            );
        } catch (ScriptException | NoSuchMethodException e) {
            return new WrapResultTest(
                    wrapInputTest.packageId,
                    new ResultTest(
                            wrapInputTest.inputTest.testName,
                            wrapInputTest.inputTest.expectedResult,
                            null,
                            true
                    )
            );
        }
    }
}
