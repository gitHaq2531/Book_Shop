package com.client.BookShop_AK.Module;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ReadData {
	@Test
	
	public void readData() {
	WebDriver d = new ChromeDriver();
	d.manage().window().maximize();
	d.get("http://49.249.28.218:8081/TestServer/Build/Online_Book_Shop_System/index.php");
		
		
		
	}
}
