package com.client.BookShop_AK.Footer;

import org.testng.annotations.Test;

import com.client.BookShopSystem.BaseUtility.BaseClass;
import com.client.BookShopSystem.ObjectRepository.SocialMediaLinkPage;

public class VerifyFaceBookLink extends BaseClass { 
	@Test(groups="Smoke" )  
	public void clickOnFaceBookLink() {
		SocialMediaLinkPage smlp = new SocialMediaLinkPage(driver);
		smlp.clickOnFacebookLink();
		System.out.println("FaceBookLink Click succesfully");
	
		
		smlp.clickOnFacebookLinkAndClosePopup();;
	}
	
	
	
	
	

}
