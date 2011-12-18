package mugcompare.config.driver;

import java.util.HashMap;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "driver_config")
public class DriverConfig {

    private HashMap<String,DriverInformation> driver = new HashMap<String, DriverInformation>();

    @XmlElement(name = "driver")
    public DriverInformation[] getDriver() {
        return driver.values().toArray(new DriverInformation[driver.size()]);
    }

    public void setDriver(DriverInformation[] driverInfo) {
        for (DriverInformation d : driverInfo) {
            driver.put(d.getName(), d);
        }
    }
    
    public HashMap<String,DriverInformation> getDriverMap() {
        return driver;
    }    
    
}
