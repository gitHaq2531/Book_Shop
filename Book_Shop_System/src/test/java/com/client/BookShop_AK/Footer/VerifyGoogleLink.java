package com.client.BookShop_AK.Footer;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.client.BookShopSystem.BaseUtility.BaseClass;
import com.client.BookShopSystem.ObjectRepository.SocialMediaLinkPage;

public class VerifyGoogleLink extends BaseClass {
	@Test(groups="Smoke")
	public void clickOnGoogleLink() {
		SocialMediaLinkPage smlp= new SocialMediaLinkPage(driver);
		smlp.clickOnGoogleLink();
		System.out.println("click on google link");
		Assert.assertTrue(smlp.verifyGoogleLogo(),"Google logo is NOT displayed!");
		System.out.println("Google logo is displayed successfully!");
		driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		
		driver.navigate().refresh();
		driver.switchTo().alert().accept();
	}

}