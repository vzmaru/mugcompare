package mugcompare;

import mugcompare.compare.DBComparator;
import mugcompare.config.ConfigurationFile;

/**
 * Start point for MugCompare.
 * @author leandro
 *
 */
public class MugCompare {
	//TODO:improve it with anything like args4j
    public static String DRIVER_CONFIG_FILE_PARAMETER = "--driverConfigFile=";
    public static String DATABASE_COMPARE_FILE_PARAMETER = "--databaseCompareFile=";
    public static String OUTPUT_FILE_PARAMETER = "--outputFile=";
    public static String OUTPUT_FILE_TYPE_PARAMETER = "--outputFileType=";
    
    public static void main(String[] args) {
    	
    	//TODO:improve it with anything like args4j
        for (String arg : args) {
        	
            if (arg.startsWith(DRIVER_CONFIG_FILE_PARAMETER)) {
                ConfigurationFile.setDriverConfigFile(arg.split("=")[1]);
            }
            else if (arg.startsWith(DATABASE_COMPARE_FILE_PARAMETER)) {
                ConfigurationFile.setDatabaseCompareFile(arg.split("=")[1]);
            }
            else if (arg.startsWith(OUTPUT_FILE_PARAMETER)) {
                ConfigurationFile.setOutputFile(arg.split("=")[1]);
            }
            else if (arg.startsWith(OUTPUT_FILE_TYPE_PARAMETER)) {
                ConfigurationFile.setOutputFileType(arg.split("=")[1]);
            }
            else {
            	System.out.println("[ERROR] Invalid Parameter. \n\n" +
            			"Usage: java -jar mugcompare.jar \n" +
            			"\n" +
            			"Parameters:\n" +
            			"  --driverConfigFile=mydriverconfigfile.xml \n" +
            			"  --databaseCompareFile=mydatabasefile.xml \n" +
            			"  --outputFile=myoutputfile.txt \n" +
            			"  --outputFileType=txt");
            	System.exit(1);
            }
            
        }
        
        //run the tool
        new DBComparator();
        
    }
    
}
