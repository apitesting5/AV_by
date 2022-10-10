package utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFile {
	
	
	public static String readPropertiesFile(String str) {
		Properties prop = new Properties();
		InputStream input;
		try {
			input = new FileInputStream("/Users/georgdankov/eclipse-workspace/AV_by_FW/src/main/resources/properties/config.properties");
			prop.load(input);
		} catch (Exception e) {
		
			e.printStackTrace();
		}

		return prop.getProperty(str);
	}

}
