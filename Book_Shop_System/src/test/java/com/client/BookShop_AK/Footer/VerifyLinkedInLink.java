package com.client.BookShop_AK.Footer;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.client.BookShopSystem.BaseUtility.BaseClass;
import com.client.BookShopSystem.ObjectRepository.SocialMediaLinkPage;

public class VerifyLinkedInLink extends BaseClass {
	@Test(groups="smoke")
	public void verifyLinkedInLink() {
		SocialMediaLinkPage smlp = new SocialMediaLinkPage(driver);
		smlp.clickOnLinkedInButton();
		 System.out.println("Clicked on LinkedIn link successfully");
		 
		
		String currenturl = driver.getCurrentUrl();
	String expectedurl="https://www.linkedin.com/company/strand-book-store/";
	
		Assert.assertEquals(currenturl, expectedurl, "LinkedIn URL is incorrect");
		WebElement cutbutton=driver.findElement(By.xpath("(//*[name()='svg' and contains(@class,'artdeco-icon') and contains(@class,'lazy-loaded')])[1]"));
		cutbutton.click();
		
		
		driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		driver.navigate().refresh();
		driver.switchTo().alert().accept();		
	}
	
	
	
	

}
