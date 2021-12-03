import java.util.List;

public class WrapInputTestList {
    public final String packageId;
    public final String JS;
    public final String functionName;
    public final List<InputTest> inputTestList;

    public WrapInputTestList(String packageId, String jscript, String functionName, List<InputTest> inputTestList) {
        this.packageId = packageId;
        this.jscript = jscript;
        this.functionName = functionName;
        this.inputTestList = inputTestList;
    }
}
