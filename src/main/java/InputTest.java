import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class InputTest {
    public final String testName;
    public final Object[] params;
    public final String expectedResult;

    @JsonCreator
    public InputTest(
            @JsonProperty("testName") String testName,
            @JsonProperty("params") Object[] params,
            @JsonProperty("expectedResult") String expectedResult
    ) {
        this.testName = testName;
        this.params = params;
        this.expectedResult = expectedResult;
    }
}
