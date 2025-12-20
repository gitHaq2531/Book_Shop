package com.client.BookShopSystem.BaseAPICLass;

import java.io.IOException;
import java.sql.SQLException;
import static io.restassured.RestAssured.basic;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.client.BookShopSystem.GenericUtility.DatabaseUtility;
import com.client.BookShopSystem.GenericUtility.FileUtility;
import com.client.BookShopSystem.GenericUtility.JavaUtility;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BaseAPIClass {
	
	public JavaUtility jv= new JavaUtility();
	public FileUtility fu= new FileUtility();
	public DatabaseUtility dbu=new DatabaseUtility();
	public static RequestSpecification  reqspecobj;
	public static ResponseSpecification resspecobj;
	
	@BeforeSuite
	
	public  void configBs() throws SQLException,IOException
	{
		dbu.connectToTheDataBase();
		System.out.println("===========connect to the database==========");
		RequestSpecBuilder builder= new RequestSpecBuilder();
		builder.setContentType(ContentType.JSON);
		builder.setAuth(basic("username", "password"));
		builder.addHeader("", "");
		builder.setBaseUri(fu.getDataFromPropertyFile("BASEUri"));
		reqspecobj=builder.build();
		
		ResponseSpecBuilder resbuilder=new ResponseSpecBuilder();
		resbuilder.expectContentType(ContentType.JSON);
		 resspecobj=resbuilder.build();
	}
	@AfterSuite
	public void configAS() {
		
		//dbu.closeDbConnection();
	}

		
		
	}
	
	
	
	
	


