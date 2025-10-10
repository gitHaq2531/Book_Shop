package com.client.BookShopSystem.GenericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility 
{
	public int getRandomeNumber(){ 
		Random random = new Random();
		int ranNumber = random.nextInt(50);
		return ranNumber;
		
	}
	public int getRandomeNumber(int n){ 
		Random random = new Random();
		int ranNumber = random.nextInt(n);
		return ranNumber;
		
	}
	public int getRandomeNumber(int from, int to){ 
		Random random = new Random();
		int ranNumber = random.nextInt(from, to);
		return ranNumber;
		
	}
	
	public String getSystemDate() {
		Date dateObj = new Date();
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = simple.format(dateObj);
		return dateString;
		
		
	}
	public String getSystemTime() {
		Date dateObj = new Date();
		SimpleDateFormat simple = new SimpleDateFormat("HH:mm:ss");
		String dateString = simple.format(dateObj);
		return dateString;
		
	}
	public String getSystemDateAndTime() {
		Date dateObj = new Date();
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = simple.format(dateObj);
		return dateString;
		
	}
	


}
