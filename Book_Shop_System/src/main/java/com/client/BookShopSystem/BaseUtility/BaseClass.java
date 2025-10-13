package com.client.BookShopSystem.BaseUtility;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.xml.XmlTest;
import com.client.BookShopSystem.GenericUtility.FileUtility;
import com.client.BookShopSystem.GenericUtility.WebDriverUtility;
import com.client.BookShopSystem.ObjectRepository.HomePage;
import com.client.BookShopSystem.ObjectRepository.LoginPage;

public class BaseClass {
	public WebDriver driver = null;
	static String browser = null;
	public LoginPage lp;
	public HomePage hp;
	public FileUtility futils = new FileUtility();
	public WebDriverUtility webDrUtil;

	@BeforeSuite
	public void beforeSuitConfigMethod() {
		System.out.println("suit level configuration start");
		System.out.println("database connected");
	}

	@BeforeClass
	public void beforeClassConfigMethod(XmlTest test) {
		System.out.println("class level configuration start");

		// getting browser either from cmd(jenkins) or suite file or properties file...
		browser = System.getProperty("browser");
		if (browser == null) {
			browser = test.getParameter("browser");
			if (browser == null) {
				browser = futils.getDataFromPropertyFile("browser");
				System.out.println(browser);

			}
		}
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		}
		UtilityClassObject.setDriver(driver);
		driver = UtilityClassObject.getDriver();
		webDrUtil = new WebDriverUtility(driver);
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// getting url either from cmd(jenkins) or suite file or properties file...
		String url = System.getProperty("url");
		if (url == null) {
			url = test.getParameter("url");
			if (url == null) {
				url = futils.getDataFromPropertyFile("url");

			}
		}

		driver.get(url);
		System.out.println("browser launched and appllication opened");
	}

	@BeforeMethod
	public void beforeMethodConfigMethod() {
		System.out.println("method level configuration start");
		String userName = futils.getDataFromPropertyFile("username");
		String password = futils.getDataFromPropertyFile("password");
		lp.login(userName, password); 
	}

	@AfterMethod
	public void afterMethodConfigMethod() {
		hp.logOut();
		System.out.println("user LogOut...");

	}

	@AfterClass
	public void afterClassConfigMethod() {
		driver.manage().window().minimize();
		driver.quit();
		UtilityClassObject.removerDriver(); // to remove all the local driver instances from thread local...
		System.out.println("browser closed...");
	}

	@AfterSuite
	public void afterSuiteConfigMethod() {
		System.out.println("databse connection closed...");
	}
}
