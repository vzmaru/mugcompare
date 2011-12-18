package mugcompare.compare;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * DB diff list POJO.
 * @author leandro
 *
 */
public class DBDifferenceModel {
	private static DBDifferenceModel instance;
	private List<String> tableDiffSrcTgt;
	private List<String> tableDiffTgtSrc;
	private List<String> notFoundTables;
	private Map<String, List<String>> srcColumnDiff;
	private Map<String, List<String>> tgtColumnDiff;
	
	private DBDifferenceModel() { }
	
	public static DBDifferenceModel getInstance() {
		if (instance == null) {
			instance = new DBDifferenceModel();
		}
		return instance;
	}
	
	public List<String> getTableDiffSrcTgt() {
		return tableDiffSrcTgt;
	}
	
	public void setTableDiffSrcTgt(List<String> tableDiffSrcTgt) {
		this.tableDiffSrcTgt = tableDiffSrcTgt;
	}
	
	public List<String> getTableDiffTgtSrc() {
		return tableDiffTgtSrc;
	}

	public void setTableDiffTgtSrc(List<String> tableDiffTgtSrc) {
		this.tableDiffTgtSrc = tableDiffTgtSrc;
	}
	
	public List<String> getNotFoundTables() {
        return notFoundTables;
    }

    public void setNotFoundTables(List<String> notFoundTables) {
        this.notFoundTables = notFoundTables;
    }
    
    public Map<String, List<String>> getSrcColumnDiff() {
        if (srcColumnDiff == null) {
            srcColumnDiff = new HashMap<String, List<String>>();
        }
        return srcColumnDiff;
    }

    public void setSrcColumnDiff(Map<String, List<String>> srcColumnDiff) {
        this.srcColumnDiff = srcColumnDiff;
    }

    public Map<String, List<String>> getTgtColumnDiff() {
        if (tgtColumnDiff == null) {
            tgtColumnDiff = new HashMap<String, List<String>>();
        }
        return tgtColumnDiff;
    }

    public void setTgtColumnDiff(Map<String, List<String>> tgtColumnDiff) {
        this.tgtColumnDiff = tgtColumnDiff;
    }
    
    public String printColumnDifferences() {
        StringBuilder str = new StringBuilder();
        
        str.append("\nColumn differences on Source database: " + srcColumnDiff.keySet().size() + "\n");
        str.append(printColumns(srcColumnDiff));
        str.append("\n\nColumn differences on Target database: " + tgtColumnDiff.keySet().size() + "\n");
        str.append(printColumns(tgtColumnDiff));
        
        return str.toString();
    }

    private String printColumns(Map<String, List<String>> tables) {
        StringBuilder str = new StringBuilder();
        
        for (String table : tables.keySet()) {
            str.append(" Table: [" + table + "]");
            List<String> columns = tables.get(table);
            for (String column : columns) {
                str.append("\n -> " + column);
            }
        }
        
        return str.toString();
    }

    public String printTableDifferences() {
		StringBuilder str = new StringBuilder();
		
		str.append("Table differences: \n");
		if (tableDiffSrcTgt.size() > 0) {
		    str.append(" Only in source database: " + tableDiffSrcTgt.size() + "\n");
		    for (String table : tableDiffSrcTgt) {
		        str.append("  " + table + "\n");
		    }
		}

		if (tableDiffTgtSrc.size() >0) {
		    str.append(" Only in target database: " + tableDiffTgtSrc.size() + "\n");
		    for (String table : tableDiffTgtSrc) {
		        str.append("  " + table + "\n");
		    }
		}
		
		if (tableDiffSrcTgt.size() + tableDiffTgtSrc.size() == 0) {
		    str.append(" ** None **\n");
		}
		
		return str.toString();
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("\nDiff results:\n");
		str.append(printTableDifferences());
		str.append(printColumnDifferences());
		return str.toString();
	}
	
}
