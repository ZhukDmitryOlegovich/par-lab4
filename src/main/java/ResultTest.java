enum StatusTest {
    PASSED,
    FAILED,
    CRASHED
}

public class ResultTest {
    public final InputTest inputTest;
    public final String receivedResult;

    public ResultTest(InputTest inputTest, String receivedResult) {
        this.inputTest = inputTest;
        this.receivedResult = receivedResult;
    }
}
