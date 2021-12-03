public class InputTest {
    public final String testName;
    public final Object[] params;
    public final String expectedResult;

    public InputTest(String testName, Object[] params, String expectedResult) {
        this.testName = testName;
        this.params = params;
        this.expectedResult = expectedResult;
    }
}
