package mugcompare.config.compare;

import javax.xml.bind.annotation.XmlElement;

public class OutputSettings {
	private String format;

	@XmlElement(name = "format")
	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}
	
}
