package BaseClass;

import java.io.FileInputStream;
import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.CommonUtility;


public class BaseClass {
	public static  WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;
	public static CommonUtility commonutil; 
	
	
	
	  public  BaseClass() {
	  
		  
		 //BrowserLaunch	  
		  prop=new Properties();
		  try {
			FileInputStream input=new FileInputStream("G:\\eclipse-java-photon-R-win32\\eclipse\\NewWorkspace\\SmallCase\\src\\Config\\PropertiesFile.xml");
		    prop.load(input);
		  
		  } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		   
		  }
			  public static void initialiation() {
				  String browsername=prop.getProperty("browser");
				  if(browsername.equals("chrome")) {
					  System.setProperty("webdriver.chrome.driver", "C:\\Users\\ANITHA\\Downloads\\chromedriver_win32\\chromedriver.exe");
				  driver=new ChromeDriver();
				  driver.manage().window().maximize();
				  }	

	 	  }
}
	

	
	