package com.client.Bookshop_AK_API;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class sampleProgramForReadTest {
	@Test
	public void getRequest() {
		
		given()
.when()
.get("http://49.249.28.218:8091/projects")
.then()
.log().all();
}}
