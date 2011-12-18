package mugcompare.report;

import mugcompare.compare.DBDifferenceModel;

public class XmlReport extends Report {

    public XmlReport(DBDifferenceModel diff) {
        super(diff);
    }

    @Override
    public String getFileContent() {
        return null;
    }

}
