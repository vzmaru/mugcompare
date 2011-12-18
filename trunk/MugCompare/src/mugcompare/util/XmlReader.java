package mugcompare.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 * Reads a XML file.
 * 
 * @author leandro
 */
public class XmlReader <T> {
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public T readXml(String xmlFile, Class clazz) {
        JAXBContext context;
        Unmarshaller unmarshaller;
        T objToReturn = null;
        
        try {
            context = JAXBContext.newInstance(clazz);
            unmarshaller = context.createUnmarshaller();
            objToReturn = (T) unmarshaller.unmarshal(new FileInputStream(xmlFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        
        return objToReturn;
    }
    
}
