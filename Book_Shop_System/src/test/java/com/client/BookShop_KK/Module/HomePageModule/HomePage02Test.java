package com.client.BookShop_KK.Module.HomePageModule;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.client.BookShopSystem.BaseUtility.MaterBaseClass;

public class HomePage02Test extends MaterBaseClass {

	@Test(groups = "Smoke")
	public void veifyLoginButton() {

		hp.getLoginButton().click();
		webDrUtil.waitUntilElementToBeClickable(lp.getLoginPageText());
		Assert.assertEquals(lp.getLoginPageText().isDisplayed(), true);
	}

	@Test(groups = "Smoke")
	public void veifySignUpButton() {
		lp.getSignUPButton().click();
		webDrUtil.waitUntilElementToBeClickable(lp.getSignUPPageText());
		Assert.assertEquals(lp.getSignUPPageText().isEnabled(), true);
	}
}
