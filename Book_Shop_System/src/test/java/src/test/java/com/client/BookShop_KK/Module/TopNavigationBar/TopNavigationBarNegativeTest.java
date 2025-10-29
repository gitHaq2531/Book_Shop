package src.test.java.com.client.BookShop_KK.Module.TopNavigationBar;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.client.BookShopSystem.BaseUtility.MaterBaseClass;

public class TopNavigationBarNegativeTest extends MaterBaseClass {
	@Test
	public void demo () {
		 String value = exlutil.getDataFromExcelSheet("Kaif Khan", 11, 0);
		 System.out.println(value);
			hp.getSearchBar().sendKeys(value);
			hp.getSearchBar().sendKeys(Keys.ENTER);
			try {Thread.sleep(10);} catch (Exception e) {}
			 plp.getFirstBook().isDisplayed();
			System.out.println(plp.getFirstBook().getText());
			int priceAfterDiscount = plp.getPriceAfterDiscount(plp.getFirstBook());
//			softAssert.assertTrue(priceAfterDiscount > 0);
//			softAssert.assertTrue(plp.getActualPrice().isDisplayed());
//			softAssert.assertTrue(!plp.getBookName(plp.getFirstBook()).equals(""));
//			softAssert.assertAll();
	}
}
