package mugcompare.util;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;

import mugcompare.config.Configuration;
import mugcompare.config.compare.DatabaseSettings;
import mugcompare.config.driver.DriverInformation;

/**
 * Dinamically adds a file in the classpath and load the driver.
 * 
 * @author leandro
 *
 */
public class DatabaseConnection {
    
    private DatabaseConnection() {
        
    }
    
    //http://www.javakb.com/Uwe/Forum.aspx/java-gui/7746/Dynamic-classpath
    @SuppressWarnings({ "rawtypes" })
    public static Connection getConnection(DatabaseSettings database) {
        DriverInformation driverConfig = Configuration.getDriverConfig().getDriverMap().get(database.getDriver());
        URL jdbcFile;
        Connection conn = null;
        File file;
        
        try {
            log("[INFO] Starting connection");
            file = new File(driverConfig.getFileName());
            log("[INFO] Driver config location: " + file.getAbsolutePath());
            jdbcFile = new URL("file:" + file.getAbsolutePath());
            
            ClassLoader loader = new URLClassLoader (new URL [] { jdbcFile });
            log("[INFO] Driver class: " + driverConfig.getClassName());
            Class jdbcClass = loader.loadClass(driverConfig.getClassName());
            Driver jdbcDriver = (Driver) jdbcClass.newInstance();
            
            Properties props = new Properties();
            log("[INFO] Username: " + database.getUsername());
            log("[INFO] Password: " + database.getPassword());
            log("[INFO] ConnectionString: " + database.getConnectionString());
            props.put("user", database.getUsername());
            props.put("password", database.getPassword());

            conn = jdbcDriver.connect(database.getConnectionString(), props);
            
        } catch (SQLException e) {
            log("[FATAL] SQL error.");
        } catch (InstantiationException e) {
        	e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
        	log("[FATAL] Driver class not found. Verify your drivers.xml file.");
        } catch (MalformedURLException e) {
        	log("[FATAL] URL connection error. Verify your database.xml file.");
        }
        
        log("[INFO] your connection was established.");
        return conn;
    }
    
    private static void log(String message) {
        System.out.println("[DatabaseConnection]" + message);
    }
    
}
