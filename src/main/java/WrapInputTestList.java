import java.util.List;

public class WrapInputTestList {
    public final String packageId;
    public final String jscript;
    public final String functionName;
    public final List<InputTest> inputTest;

    public WrapInputTestList(String packageId, String jscript, String functionName, List<InputTest> inputTest) {
        this.packageId = packageId;
        this.jscript = jscript;
        this.functionName = functionName;
        this.inputTest = inputTest;
    }
}
