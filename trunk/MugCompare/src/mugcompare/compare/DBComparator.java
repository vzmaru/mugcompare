package mugcompare.compare;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import mugcompare.config.Configuration;
import mugcompare.util.DatabaseConnection;

/**
 * Compare databases. Delegate the minor parts comparation to specific classes.
 * 
 * @author leandro
 * 
 */
public class DBComparator {
	Connection connSrc = null;
	Connection connTgt = null;
	DBModel dbSrc = null;
	DBModel dbTgt = null;
	DBDifferenceModel diff = null;
	List<String> commonTables = null;

	public DBComparator() {
		commonTables = new ArrayList<String>();

		log("[INFO] connecting.");
		connSrc = DatabaseConnection.getConnection(Configuration
				.getCompareConfig().getDatabaseSource());
		log("[INFO] connected source database");

		connTgt = DatabaseConnection.getConnection(Configuration
				.getCompareConfig().getDatabaseTarget());
		log("[INFO] connected target database.");

		dbSrc = new DBModel(connSrc);
		dbTgt = new DBModel(connTgt);
		diff = DBDifferenceModel.getInstance();

		dbSrc.fillTableList();
		dbTgt.fillTableList();

		verifications();
		log(diff.toString());
	}

	private void verifications() {
		verifyTables();
		verifyColumns();
	}

	/**
	 * Verify colums correspondence in common table List. This method use table
	 * filtering list from configuration file.
	 */
	private void verifyColumns() {
		for (String tableName : commonTables) {
			List<String> srcTableCols = dbSrc.getColumns(tableName);
			List<String> tgtTableCols = dbTgt.getColumns(tableName);

			List<String> srcExclusiveColumns = compareList(srcTableCols, tgtTableCols);
			List<String> tgtExclusiveColumns = compareList(tgtTableCols, srcTableCols);

			diff.getSrcColumnDiff().put(tableName, srcExclusiveColumns);
			diff.getTgtColumnDiff().put(tableName, tgtExclusiveColumns);
		}
	}

	/**
	 * Verify table existence and correpondence. This method don't use the list
	 * in configuration file.
	 */
	private void verifyTables() {
		List<String> tableList1 = dbSrc.getTables();
		List<String> tableList2 = dbTgt.getTables();
		List<String> diff12 = compareList(tableList1, tableList2);
		List<String> diff21 = compareList(tableList2, tableList1);
		commonTables = commonItems(tableList1, tableList2);

		// found differences between source and target databases
		diff.setTableDiffSrcTgt(diff12);
		diff.setTableDiffTgtSrc(diff21);

	}

	/**
	 * Execute comparison.
	 * 
	 * @param originalList
	 * @param anotherList
	 * @return Table diff names
	 */
	private List<String> compareList(List<String> originalList,
			List<String> anotherList) {
		List<String> diffList = new ArrayList<String>();

		for (String srcTableName : originalList) {
			if (!anotherList.contains(srcTableName)) {
				diffList.add(srcTableName);
			}
		}

		return diffList;
	}

	/**
	 * Return duplicated items.
	 * 
	 * @param originalList
	 * @param anotherList
	 * @return
	 */
	private List<String> commonItems(List<String> originalList,
			List<String> anotherList) {
		List<String> common = new ArrayList<String>();

		for (String srcTableName : originalList) {
			if (!common.contains(srcTableName)) {
				common.add(srcTableName);
			}
		}

		return common;
	}

	private static void log(String message) {
		System.out.println("[DBComparator]" + message);
	}

}
