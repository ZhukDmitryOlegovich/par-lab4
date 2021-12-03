import java.util.List;

public class WrapInputTestList {
    public final String packageId;
    public final String jsScript;
    public final String functionName;
    public final List<InputTest> inputTestList;

    public WrapInputTestList(String packageId, String jsScript, String functionName, List<InputTest> inputTestList) {
        this.packageId = packageId;
        this.jsScript = jsScript;
        this.functionName = functionName;
        this.inputTestList = inputTestList;
    }
}
