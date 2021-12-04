import java.util.ArrayList;

public class WrapResultTestList {
    private final String packageId;
    private final ArrayList<ResultTest> resultTestList;

    public WrapResultTestList(String packageId, ArrayList<ResultTest> resultTestList) {
        this.packageId = packageId;
        this.resultTestList = resultTestList == null ? new ArrayList<>() : resultTestList;
    }

    private final static String FORMAT = "{\"packageId\":\"%s\",\"resultTestList\":%s}";

    @Override
    public String toString() {
        return String.format(FORMAT, packageId, resultTestList);
    }
}
