package com.client.BookShop_KK.Module.HomePageModule;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.client.BookShopSystem.BaseUtility.MaterBaseClass;
import com.client.BookShopSystem.GenericUtility.JavaUtility;
import com.client.BookShopSystem.ObjectRepository.SignUpPage;

public class HomePage02Test extends MaterBaseClass {
	JavaUtility ju = new JavaUtility();
	SignUpPage sp = new SignUpPage(driver);

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

	@Test(groups = "integration")
	public void createAccount() {
		lp.getSignUPButton().click();
		webDrUtil.waitUntilElementToBeClickable(lp.getSignUPPageText());
		int ranNum = ju.getRandomeNumber(5, 499);
		String userName = "newUser" + ranNum;
		String password = "newPass@" + ranNum;
		sp.getUserNameTF().sendKeys(userName);
		sp.getPasswordTF().sendKeys(password);
		sp.getSignUpBtn().click();
		webDrUtil.ExplicitWaitUntilAlertIsPresent();
		String alertMessage = webDrUtil.switcToAlertGetMessage();
		webDrUtil.switcToAlertAccept();
		System.out.println(alertMessage);
//		Assert.assertEquals(userName, hp.getUserName());
	}

	@Test(groups = "integration")
	public void verifyUserNamePostAccountCreation() {
		lp.getSignUPButton().click();
		webDrUtil.waitUntilElementToBeClickable(lp.getSignUPPageText());
		int ranNum = ju.getRandomeNumber(5, 499);
		String userName = "newUser" + ranNum;
		String password = "newPass@" + ranNum;
		sp.getUserNameTF().sendKeys(userName);
		sp.getPasswordTF().sendKeys(password);
		sp.getSignUpBtn().click();
		webDrUtil.ExplicitWaitUntilAlertIsPresent();
		webDrUtil.switcToAlertAccept();
		lp.login(userName, password);
		Assert.assertEquals(userName, hp.getUserName());
	}

}
