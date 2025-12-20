package com.client.BookShop_AK.Footer;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.client.BookShopSystem.BaseUtility.BaseClass;
import com.client.BookShopSystem.ObjectRepository.GetInTouchPage;

public class VerifyLetsGetInTouch extends BaseClass {

	@Test(groups="smoke")
	public void verifyLetsGetInTouchText() {
		GetInTouchPage gitp= new GetInTouchPage(driver);
		String text = gitp.getGITtextEDt().getText();
		Assert.assertEquals(text.equalsIgnoreCase("Let's Get In Touch!"), true);
		}
	
	@Test(groups="smoke")
	public void verifyPhoneNum() {
		GetInTouchPage gitp= new GetInTouchPage(driver);
		String phonenumber = gitp.getPhonenumEDT().getText();
		Assert.assertEquals(phonenumber.contains("6789"), true);
		
	}
	@Test(groups="smoke")
	public void verifyEmailId() {
		GetInTouchPage gitp= new GetInTouchPage(driver);
		String Email = gitp.getEmailEDT().getText();
		Assert.assertEquals(Email.contains("BookStore@gmail.com"), true);
	}
}
