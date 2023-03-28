package mypackage;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	
	public static WebDriver driver = null;
	
	
	public static void initialize() {
		//Singleton Pattern
		if(driver == null) {
			if(Constants.browserName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "C:\\Selenium Drivers\\chromedriver.exe");
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--remote-allow-origins=*");
				driver = new ChromeDriver(options);
			}
			else if(Constants.browserName.equalsIgnoreCase("FF")) {
				System.setProperty("webdriver.gecko.driver", "C:\\Selenium Drivers\\geckodriver.exe");
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--remote-allow-origins=*");
				driver = new FirefoxDriver(options);
			}
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(Constants.url);
	}
	
	public static void quit() {
		System.out.println("quitting the browser");
		driver.quit();
		driver = null;
	}
	
	public static void close() {
		System.out.println("closing the browser");
		driver.close();
		driver = null;
	}
	

}
