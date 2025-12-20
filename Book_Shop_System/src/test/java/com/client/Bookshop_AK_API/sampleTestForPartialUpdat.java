package com.client.Bookshop_AK_API;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import org.json.simple.JSONObject;
public class sampleTestForPartialUpdat {
	@Test
	public void partialUpdate(Object contentType) {
		JSONObject jsnobj= new JSONObject();
		
		jsnobj.put("createdBy","AfshanShaikh");
		
		
		given()
		.contentType(ContentType.JSON)
		.body(jsnobj)
		.when()
		.patch("http://49.249.28.218:8091/project/NH_PROJ_685")
		.then()
		.log().all();
		
	}

}
