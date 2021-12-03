import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class WrapResultTestList {
    private final String packageId;
    private final List<ResultTest> resultTestList;

    @JsonCreator
    public WrapResultTestList(
            @JsonProperty("packageId") String packageId,
            @JsonProperty("results") List<ResultTest> resultTestList
    ) {
        this.packageId = packageId;
        this.resultTestList = resultTestList;
    }
}
