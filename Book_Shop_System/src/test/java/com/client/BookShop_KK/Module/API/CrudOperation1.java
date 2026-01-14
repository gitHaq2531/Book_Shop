package com.client.BookShop_KK.Module.API;

import org.hamcrest.Matchers;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.client.BookShopSystem.BaseUtility.APIBaseclass;
import com.client.BookShopSystem.POJO.Employee;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static com.client.BookShopSystem.EndPoint.EndPoint.*;

public class CrudOperation1 extends APIBaseclass {
	String employeeId;

	@Test(priority = 1)
	public void post() {
		System.out.println("Post ==================================");
		Employee emp = new Employee("Architect", "10/05/1987", "nomail@gmail.com", "Adam Kelly", 25, "8699987546",
				"NewTestProject3165", "ROLE_EMPLOYEE", "User12399");
		Response post = given().spec(reqSpec).body(emp).when().post(employees);
		post.then().spec(resSpec)
		.assertThat().statusCode(201).statusLine("HTTP/1.1 201 ").log().all();
		post.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonSchema.json")).log().all();
		employeeId = post.jsonPath().getString("employeeId");

	}

	@Test(priority = 2)
	public void get() {
		given().spec(reqSpec).when().get(all_employees).then().spec(resSpec).assertThat().statusCode(200)
				.time(Matchers.lessThan(1000l)).log().all();
	}

	@Test(priority = 3,dataProvider = "employeeIds")
	public void put(String path ) {
		System.out.println("Put====================");
		Employee emp = new Employee("Architect", "10/05/1987", "nomail@gmail.com", "Adam Kelly", 25, "000000",
				"NewTestProject3165", "ROLE_EMPLOYEE", "User12392");
		given().spec(reqSpec).pathParam("employeeId", path).basePath(employee).body(emp).when().put("{employeeId}").then().spec(resSpec).assertThat()
				.statusCode(200).time(Matchers.lessThan(1000l)).log().all();
	}

	@Test(priority = 4)
	public void delete() {
		System.out.println("Delete =====================");
		given().spec(reqSpec).basePath(employee).when().delete(employeeId).then().assertThat().statusCode(500).log()
				.all();
	}
	@DataProvider(name = "employeeIds")
	public Object[][] getEmployeeIds() {
	    return new Object[][] {
	        { "NH_00200" },
	        { "NH_00199" },
	        { "NH_00198" },
	        { "NH_00154" },
	        { "NH_00153" },
	        { "NH_00152" },
	        { "NH_00151" },
	        { "NH_00150" },
	        { "NH_00149" },
	        { "NH_00148" }
	    };
	}
	
	

}
