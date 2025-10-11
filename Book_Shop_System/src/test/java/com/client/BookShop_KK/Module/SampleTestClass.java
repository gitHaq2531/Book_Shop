package com.client.BookShop_KK.Module;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.client.BookShopSystem.BaseUtility.BaseClass;
@Listeners(com.client.BookShopSystem.ListenerUtility.ListenerImpClass.class)
public class SampleTestClass extends BaseClass {
	@Test
	public void Mytest() 
	{
		System.out.println(futils.getDataFromPropertyFile("url"));
		
	}
	
	

}
