package com.client.BookShopSystem.BaseUtility;

import org.hamcrest.Matchers;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class APIBaseclass {
	public ResponseSpecification resSpec;
	public RequestSpecification reqSpec;

	@BeforeSuite
	public void beforeSuite() {
		RequestSpecBuilder reqSB = new RequestSpecBuilder();
		reqSB.setBaseUri("http://49.249.28.218:8091").setContentType(ContentType.JSON);
		reqSpec = reqSB.build();
		ResponseSpecBuilder resSB = new ResponseSpecBuilder();
		resSB.expectContentType(ContentType.JSON).expectResponseTime(Matchers.lessThan(1000l));
		resSpec = resSB.build();
	}

	@AfterSuite
	public void afterSuite() {

	}
}
