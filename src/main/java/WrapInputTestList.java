import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class WrapInputTestList {
    public final String packageId;
    public final String jsScript;
    public final String functionName;
    public final List<InputTest> inputTestList;

    @JsonCreator
    public WrapInputTestList(
            @JsonProperty("packageId") String packageId,
            @JsonProperty("jsScript") String jsScript,
            @JsonProperty("functionName") String functionName,
            List<InputTest> inputTestList) {
        this.packageId = packageId;
        this.jsScript = jsScript;
        this.functionName = functionName;
        this.inputTestList = inputTestList;
    }
}
