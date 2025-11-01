package com.client.BookShop_KK.Module.HomePageModule;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.client.BookShopSystem.BaseUtility.MaterBaseClass;
import com.client.BookShopSystem.GenericUtility.JavaUtility;

public class HomePage02Test extends MaterBaseClass {
	JavaUtility ju = new JavaUtility();
	@Test(groups = { "Smoke","negative"})
	public void LoginButtonVerificationTest() {

		WebElement loginButton = hp.getLoginButton();
		loginButton.click();
		webDrUtil.waitUntilElementToBeClickable(loginButton);
		Assert.assertEquals(loginButton.isDisplayed(), true);
		lp.getCloseBtn().click();
	}

	@Test(groups = { "Smoke","negative"})
	public void SignUpButtonVerificationTest() {
		lp.getSignUPButton().click();
		webDrUtil.waitUntilElementToBeClickable(lp.getSignUPPageText());
		Assert.assertEquals(lp.getSignUPPageText().isEnabled(), true);
		sp.getCloseBtn().click();
	}

	@Test(groups = { "Smoke","negative"})
	public void createAccountVerificationTest() {
		webDrUtil.waitUntilInvisibilityOf(sp.getCloseBtn());
		lp.getSignUPButton().click();
		webDrUtil.waitUntilElementToBeClickable(lp.getSignUPPageText());
		int ranNum = ju.getRandomeNumber(5, 499);
		String userName = "newUser" + ranNum;
		String password = "newPass@" + ranNum;
		sp.getUserNameTF().sendKeys(userName);
		sp.getPasswordTF().sendKeys(password);
		webDrUtil.waitUntilElementToBeClickable(sp.getSignUpBtn());
		sp.getSignUpBtn().click();
		webDrUtil.ExplicitWaitUntilAlertIsPresent();
		String alertMessage = webDrUtil.switcToAlertGetMessage();
		webDrUtil.switcToAlertAccept();
		Assert.assertEquals(alertMessage, "Successfully Registered!!!");
	}

	@Test(groups = { "Smoke","negative"})
	public void userNamePostAccountCreationVerificationTest() {
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
