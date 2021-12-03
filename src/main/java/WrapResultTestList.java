import java.util.List;

public class WrapResultTestList {
    private final String packageId;
    private final String jsscript;
    private final String funcName;
    private final List<ResultTest> resultTestList;

    public WrapResultTestList(String packageId, String jsscript, String funcName, List<ResultTest> resultTestList) {
        this.jsscript = jsscript;
        this.funcName = funcName;
        this.packageId = packageId;
        this.resultTestList = resultTestList;
    }
}
