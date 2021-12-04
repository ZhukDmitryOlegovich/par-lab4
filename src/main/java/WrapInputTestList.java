import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class WrapInputTestList {
    public final String packageId;
    public final String jsScript;
    public final String functionName;
    public final ArrayList<InputTest> inputTestList;

    @JsonCreator
    public WrapInputTestList(
            @JsonProperty("packageId") String packageId,
            @JsonProperty("jsScript") String jsScript,
            @JsonProperty("functionName") String functionName,
            @JsonProperty("tests") ArrayList<InputTest> inputTestList
    ) {
        this.packageId = packageId;
        this.jsScript = jsScript;
        this.functionName = functionName;
        this.inputTestList = inputTestList;
    }
}
