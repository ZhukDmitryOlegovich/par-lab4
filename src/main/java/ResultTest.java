import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultTest {
    public final String testName;
    public final String expectedResult;
    public final String receivedResult;
    public final boolean isCrashed;

    @JsonCreator
    public ResultTest(
            @JsonProperty("testName") String testName,
            @JsonProperty("expectedResult") String expectedResult,
            @JsonProperty("receivedResult") String receivedResult,
            @JsonProperty("isCrashed") boolean isCrashed
    ) {
        this.testName = testName;
        this.expectedResult = expectedResult;
        this.receivedResult = receivedResult;
        this.isCrashed = isCrashed;
    }

    public String getTestName() {
        return testName;
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    public String getReceivedResult() {
        return receivedResult;
    }

    public boolean getIsCrashed() {
        return isCrashed;
    }
}
