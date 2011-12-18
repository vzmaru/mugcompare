package mugcompare.config;

import mugcompare.util.DefaultConfiguration;

/**
 * here the configurations are loaded and used.
 * @author leandro
 *
 */
public class ConfigurationFile {
    private static String driverConfigFile = DefaultConfiguration.DRIVER_CONFIG_FILE;
    private static String databaseCompareFile = DefaultConfiguration.DATABASE_COMPARE_FILE;
    private static String outputFile = DefaultConfiguration.OUTPUT_FILE;
    private static String outputFileType = DefaultConfiguration.OUTPUT_FILE_TYPE;
    
    public static String getDriverConfigFile() {
        return driverConfigFile;
    }
    
    public static void setDriverConfigFile(String _driverConfigFile) {
        driverConfigFile = _driverConfigFile;
    }
    
    public static String getDatabaseCompareFile() {
        return databaseCompareFile;
    }
    
    public static void setDatabaseCompareFile(String _databaseCompareFile) {
        databaseCompareFile = _databaseCompareFile;
    }

    public static String getOutputFile() {
        return outputFile;
    }

    public static void setOutputFile(String _outputFile) {
        outputFile = _outputFile;
    }

    public static String getOutputFileType() {
        return outputFileType;
    }

    public static void setOutputFileType(String _outputFileType) {
        outputFileType = _outputFileType;
    }
    
}
