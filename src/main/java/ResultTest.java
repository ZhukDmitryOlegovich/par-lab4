import java.util.Objects;

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
                : Objects.equals(inputTest.expectedResult, receivedResult)
                ? StatusTest.PASSED
                : StatusTest.FAILED;
    }
}
