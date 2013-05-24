package controller;

import java.io.File;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

/**
 * This class is used to read and write data to and from 
 * an XML-file.
 * @author Bjorn from UIP I course
 * @author Jimmy from UIP I course
 * @author Deha
 */
public class XMLHandler {
	private static final String fileName = "items.xml";
	private static final String dirName = System.getProperty("user.home") + "/Group3-Calendar/";
	private static final String fullPath = dirName + fileName;
	
    public static final File XML_ITEMS = new File(fullPath);
	private final Serializer serializer;

	/**
	 * Initiate the serializer used to serialize and deserialize 
	 * data between Java and XML
	 */
    public XMLHandler() {
        setDirectory();
    	serializer = new Persister();
    }
   
    /**
     * creates directory at user's home for the xml file
     */
    private void setDirectory(){
		
		File targetDir = new File(dirName);

		if (!targetDir.exists()) {
			targetDir.mkdir();
		}
	}
    
    /**
     * Reads an XML-file.
     * @param destinationObject The Java-object to write data to
     * @param sourceFile The XML-file to get data from
     */
	public void readXML(Object destinationObject, File sourceFile) {
		try {
			serializer.read(destinationObject, sourceFile);
		} catch (Exception e) {
			System.err.println("XML-file empty or unreadable.");
		}
	}
	
	/**
	 * Writes to an XML-file.
	 * @param sourceObject The Java-object to get data from
	 * @param destinationFile The XML-file to write data to
	 */
	public void writeXML(Object sourceObject, File destinationFile) {
		try {
			serializer.write(sourceObject, destinationFile);
		} catch (Exception e) {
			System.err.println("Couldn't write to XML-file.");
		}
	}

}
