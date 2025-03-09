package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	private WebDriver driver;

	public WebDriver WebDriverManager() throws IOException {
			
			FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//global.properties");
			Properties prop=new Properties();
			prop.load(fis);
			String url=prop.getProperty("QAUrl");
			
			if(driver==null) {
				if(prop.getProperty("browser").equalsIgnoreCase("chrome")) 
				{
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
					
				}
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				driver.get(url);
			}
		    return driver;
	}

}
