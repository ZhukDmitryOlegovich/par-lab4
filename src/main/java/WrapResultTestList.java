import java.util.List;

public class WrapResultTestList {
    private final String packageId;
    private final String jsScript;
    private final String funcName;
    private final List<ResultTest> resultTestList;

    public WrapResultTestList(String packageId, String jsScript, String funcName, List<ResultTest> resultTestList) {
        this.packageId = packageId;
        this.jsScript = jsScript;
        this.funcName = funcName;
        this.resultTestList = resultTestList;
    }
}
