package com.w2a.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public class TestBase{

	/*
	 * Initializaion of below things will be done in this class WebDriver properties
	 * Webdriver-done
	 * properties- done
	 * Logs --log4j jar, .log, log4j.properties,Logger
	 * ReportNg ExtendReports 
	 * DB 
	 * Excel 
	 * Mail 
	 */
	public static WebDriver driver;
	public static Properties config = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("devpinoyLogger");

	@BeforeSuite
	public void setUp() throws IOException {
		if (driver == null) {
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\config.properties");
			
			config.load(fis);
			log.debug("Config File Loaded!!!");
			if (config.getProperty("browser").equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
				log.debug("Chrome Launched!!!");
			} else if (config.getProperty("browser").equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();
				log.debug("Edge launched!!!");
			}
		}
		driver.get(config.getProperty("testSiteURL"));
		log.debug("URL opened !!!");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
	
	public boolean isElementDisplayed(WebElement element) {
		return element.isDisplayed();

	}

	@AfterSuite
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
		log.debug("Execution Completed");

	}

}
