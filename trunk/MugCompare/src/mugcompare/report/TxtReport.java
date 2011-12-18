package mugcompare.report;

import mugcompare.compare.DBDifferenceModel;

public class TxtReport extends Report {

    public TxtReport(DBDifferenceModel diff) {
        super(diff);
    }

    @Override
    public String getFileContent() {
        return null;
    }

}
