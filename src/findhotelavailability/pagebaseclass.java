package findhotelavailability;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class pagebaseclass {
	public void setProperty(String key, String value)
    {
        try
        {
        //Create the File object and pass the 'properties file location in File constructor.
        File file = new File(System.getProperty("user.dir") + "//TestData//" + "config.properties");

        //Create FileInputstream object to read the file
        FileInputStream fileInput = new FileInputStream(file);

        // Create properties class object 
        Properties prop = new Properties();

        // Load the property file in Inputstream
        prop.load(fileInput);

        // writing value into properties file
        // key = url , Value = www.padhle.com
        prop.setProperty(key,value);

        // Create FileOutStream class object to write into file
        FileOutputStream outfile = new FileOutputStream(file);    
        //Store the value in property file
        prop.store(outfile,"add Url in properties file");                
 
        }
        catch(Exception e)
        {
            e.getMessage();
        }
    }
}
