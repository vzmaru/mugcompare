package mugcompare.config.compare;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "mugcompare")
public class CompareConfig {
    private DatabaseSettings databaseSource;
    private DatabaseSettings databaseTarget;
    private OutputSettings outputSettings;

    @XmlElement(name = "database_source")
    public DatabaseSettings getDatabaseSource() {
        return databaseSource;
    }
    
    public void setDatabaseSource(DatabaseSettings databaseSource) {
        this.databaseSource = databaseSource;
    }

    @XmlElement(name = "database_target")
    public DatabaseSettings getDatabaseTarget() {
        return databaseTarget;
    }
    
    public void setDatabaseTarget(DatabaseSettings databaseTarget) {
        this.databaseTarget = databaseTarget;
    }
 
    @XmlElement(name = "output_settings")
    public OutputSettings getOutputSettings() {
        return outputSettings;
    }

    public void setOutputSettings(OutputSettings outputSettings) {
        this.outputSettings = outputSettings;
    }
    
}
