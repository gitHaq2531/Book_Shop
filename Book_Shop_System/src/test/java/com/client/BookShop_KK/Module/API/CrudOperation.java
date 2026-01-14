package com.client.BookShop_KK.Module.API;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertThat;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.client.BookShopSystem.BaseUtility.APIBaseclass;
import com.client.BookShopSystem.POJO.Employee;

import io.restassured.response.Response;

import static com.client.BookShopSystem.EndPoint.EndPoint.*;
//import static org.hamcrest.Matchers.*;


public class CrudOperation extends APIBaseclass {

	String employeeId = "NH_00399" ;

	@Test(priority = 1)
	public void post() throws FileNotFoundException {
System.out.println("Post============================");
		Employee emp = new Employee("Architect", "10/05/1987", "nomail@gmail.com", "Adam Kelly", 25, "8699987546",
				"NewTestProject3165", "ROLE_EMPLOYEE", "User12389");
		FileInputStream jf = new FileInputStream("emp001.json");
	
		Response response = given().spec(reqSpec).body(emp).when().post(employees);
		response.then().spec(resSpec).assertThat().statusCode(201).log().all();
//		response.time();
		employeeId = response.jsonPath().getString("employeeId");
	
	}

	@Test(priority = 2)
	public void get() {
		System.out.println("Get=====================");
		Response response = given().spec(reqSpec)
		.when().get(all_employees);
		response.then().spec(resSpec).assertThat().statusCode(200).log().all();
		response.then().assertThat().time(Matchers.lessThan(1000l));
		long time = response.time();
		System.out.println(time);
		Assert.assertTrue(time<526);
		response.then().assertThat().body("name",Matchers.equalTo("kaif"));

	}

	@Test(priority = 3)
	public void update() throws FileNotFoundException {
		System.out.println("Update=====================");
		Employee emp = new Employee("Architect", "10/05/1987", "nomail@gmail.com", "Adam Kelly", 25, "0000000000",
				"NewTestProject3165", "ROLE_EMPLOYEE", "User03257");
		FileInputStream jf = new FileInputStream("emp001.json");
		given().spec(reqSpec).body(jf).basePath(employees).when().put(employeeId).then().spec(resSpec).assertThat()
				.statusCode(200).log().all();

	}

	@Test(priority = 4)
	public void delete() {

		System.out.println("Delete =====================");
		given().spec(reqSpec).basePath(employee).when().delete(employeeId).then().assertThat().statusCode(500).log()
				.all();

	}

}
