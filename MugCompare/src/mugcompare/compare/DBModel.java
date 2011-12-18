package mugcompare.compare;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Standard model to metadata of the database, used
 * to compare.
 * @author leandro
 *
 */
public class DBModel {
    DatabaseMetaData metadata;
	List<String> tables;
	//TODO: implement column lists and type to simplify tests
	Connection conn;
	
	public DBModel(Connection c) {
		conn = c;
	}
	
	public List<String> getTables() {
		if (tables == null) {
			tables = new ArrayList<String>();
		}
		return tables;
	}
	
    protected void fillTableList() {
        log("[INFO] start listing tables. ");
        try {
            ResultSet rs = getMetaData().getTables(null, null, null,new String[]{"TABLE"});
            while (rs.next()) {
                log(rs.getString("TABLE_NAME"));
                getTables().add(rs.getString("TABLE_NAME"));
            }
            rs.close();

        } catch (SQLException e) {
            log("[ERROR] error listing tables. " + e.getMessage());
        }
    }
    
    protected List<String> getColumns(String tableName) {
        List<String> columnNames = new ArrayList<String>();
        String columnName = null;
        
        log("[INFO] start getting columns for " + tableName);
        try {
            ResultSet rs = getMetaData().getColumns(null, null, tableName, null);
            while (rs.next()) {
                columnName = rs.getString("COLUMN_NAME");
                columnNames.add(columnName);
            }
        } catch (SQLException e) {
            log("[ERROR] problem getting table metadata for: " + tableName);
        }
        
        return columnNames;
    }
    
    private DatabaseMetaData getMetaData() {
        try {
            log("[INFO] trying to get metadata information.");
            if (metadata == null) {
                metadata = conn.getMetaData();
            }
            
            return metadata;
        } catch (SQLException e) {
            log("[ERROR] this database does not provide metadata information.");
            System.exit(0);
        }
        
        return null;
    }
    
    private static void log(String message) {
        System.out.println("[DBModel]" + message);
    }
	
}
