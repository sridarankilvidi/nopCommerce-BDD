package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties prop;
	
	public ReadConfig() {
		
		File src = new File("./Configurations/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
			
		}catch (Exception e){
			System.out.println("Exception is: " + e.getMessage());
		}
		
	}
	
		
	public String getChromePath() {
		String chromepath = prop.getProperty("chromepath");
		return chromepath;
	}
	
	public String getFirefoxPath() {
		String firefoxpath = prop.getProperty("firefoxpath");
		return firefoxpath;
	}
	
	public String getEdgePath() {
		String edgepath = prop.getProperty("edgepath");
		return edgepath;
	}
	
	public String getLog4jPath() {
		String Log4jpath = prop.getProperty("log4jpath");
		return Log4jpath;
	}
	
	public String getBrowser() {
		String br = prop.getProperty("browser");
		return br;
	}
	
}
