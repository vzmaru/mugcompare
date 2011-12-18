package mugcompare.config.compare;

import javax.xml.bind.annotation.XmlElement;

public class DatabaseSettings {
    private String driver;
    private String connectionString;
    private String username;
    private String password;
    
    @XmlElement(name = "driver")
    public String getDriver() {
        return driver;
    }
    
    public void setDriver(String driver) {
        this.driver = driver;
    }
    
    @XmlElement(name = "connection_str")
    public String getConnectionString() {
        return connectionString;
    }
    
    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }
    
    @XmlElement(name = "username")
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    @XmlElement(name = "password")
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
}
