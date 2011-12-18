package mugcompare.report;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import mugcompare.compare.DBDifferenceModel;


public abstract class Report {
    protected DBDifferenceModel diff;
    
    public Report(DBDifferenceModel diff) {
        this.diff = diff;
    }
    
    public DBDifferenceModel getDiff() {
        return diff;
    }

    public abstract String getFileContent();
    
    public void writeOutputFile(String fileName) {
        String fileContent = getFileContent();
        
        try {
            FileWriter file = new FileWriter(fileName);
            BufferedWriter out = new BufferedWriter(file);
            out.write(fileContent);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
