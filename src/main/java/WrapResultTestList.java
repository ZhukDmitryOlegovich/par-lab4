import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class WrapResultTestList {
    private final String packageId;
    private final ArrayList<ResultTest> resultTestList;

    @JsonCreator
    public WrapResultTestList(
            @JsonProperty("packageId") String packageId,
            @JsonProperty("results") ArrayList<ResultTest> resultTestList
    ) {
        this.packageId = packageId;
        this.resultTestList = resultTestList;
    }

    public String getPackageId() {
        return packageId;
    }

    public ArrayList<ResultTest> getResultTestList() {
        return resultTestList;
    }
}
