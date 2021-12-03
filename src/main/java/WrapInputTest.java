public class WrapInputTest {
    public final String packageId;
    public final String jsScript;
    public final String functionName;
    public final InputTest inputTest;

    public WrapInputTest(String packageId, String jsScript, String functionName, InputTest inputTest) {
        this.packageId = packageId;
        this.jsScript = jsScript;
        this.functionName = functionName;
        this.inputTest = inputTest;
    }
}
