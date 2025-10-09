package com.client.BookShopSystem.GenericUtility;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility 
{
public String getDataFromPropertyFile(String key)
{
	String data=null;
	try {
		FileInputStream fis=new FileInputStream("path");
		Properties pobj=new Properties();
		pobj.load(fis);
		data=pobj.getProperty(key);
		}
		catch (Exception e) {
		}
	return data;
}
}
