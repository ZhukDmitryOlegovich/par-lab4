import java.util.List;

public class WrapResultTestList {
    private final String packageId;
    private final List<ResultTest> resultTestList;

    public WrapResultTestList(String packageId, List<ResultTest> resultTestList) {
        this.packageId = packageId;
        this.resultTestList = resultTestList;
    }
}
