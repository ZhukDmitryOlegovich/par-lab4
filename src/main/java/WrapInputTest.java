public class WrapInputTest {
    public final String packageId;
    public final String jscript;
    public final String functionName;
    public final InputTest inputTest;

    public WrapInputTest(String packageId, String jscript, String functionName, InputTest inputTest) {
        this.packageId = packageId;
        this.jscript = jscript;
        this.functionName = functionName;
        this.inputTest = inputTest;
    }
}
