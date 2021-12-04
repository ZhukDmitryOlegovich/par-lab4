enum StatusTest {
    PASSED,
    FAILED,
    CRASHED
}

public class ResultTest {
    public final InputTest inputTest;
    public final String receivedResult;
    public final StatusTest statusTest;

    public ResultTest(InputTest inputTest, String receivedResult, boolean isCrashed) {
        this.inputTest = inputTest;
        this.receivedResult = receivedResult;
        this.statusTest = isCrashed
                ? StatusTest.CRASHED
                : inputTest.expectedResult.equals(receivedResult)
                ? StatusTest.PASSED
                : StatusTest.FAILED;
    }

    private final static String FORMAT = "{\"status\":\"%s\",\"testName\":\"%s\","
            + "\"expectedResult\":\"%s\",\"receivedResult\":\"%s\"}";

    @Override
    public String toString() {
        return String.format(FORMAT, statusTest.name(), inputTest.testName, inputTest.expectedResult, receivedResult);
    }
}
