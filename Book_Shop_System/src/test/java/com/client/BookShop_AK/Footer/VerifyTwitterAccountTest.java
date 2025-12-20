package com.client.BookShop_AK.Footer;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.client.BookShopSystem.BaseUtility.BaseClass;
import com.client.BookShopSystem.ObjectRepository.SocialMediaLinkPage;

public class VerifyTwitterAccountTest extends BaseClass {
	
	@Test(groups="smoke")
	public void twitterLink() {
		
		SocialMediaLinkPage smlp= new SocialMediaLinkPage(driver);
		smlp.clickOnTwitterbutton();
		
		WebElement logo = smlp.getLinkLogoEDT();
	 Assert.assertEquals( smlp.getLinkLogoEDT().isDisplayed(),true);
	driver.navigate().back();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
	driver.navigate().refresh();
	driver.switchTo().alert().accept();
	
	
	
	}

}
