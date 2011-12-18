package mugcompare.config;


import mugcompare.config.compare.CompareConfig;
import mugcompare.config.driver.DriverConfig;
import mugcompare.util.XmlReader;


/**
 * Load configuration information from files.
 * @author leandro
 *
 */
public class Configuration {
    private static DriverConfig driverConfig;
    private static CompareConfig compareConfig;
    
    static {
        driverConfig = new XmlReader<DriverConfig>().readXml(
                ConfigurationFile.getDriverConfigFile(), DriverConfig.class);
        compareConfig = new XmlReader<CompareConfig>().readXml(
                ConfigurationFile.getDatabaseCompareFile(), CompareConfig.class);
    }
    
    private Configuration() { }
    
    public static DriverConfig getDriverConfig() {
        return driverConfig;
    }

    public static CompareConfig getCompareConfig() {
        return compareConfig;
    }

}
