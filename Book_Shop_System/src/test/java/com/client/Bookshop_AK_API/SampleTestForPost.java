
package com.client.Bookshop_AK_API;
import static io.restassured.RestAssured.*;


import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class SampleTestForPost {

	@Test
	public void postReqToServer() {
	
		JSONObject jsonobj = new JSONObject();
        jsonobj.put("createdBy", "Afshan");
        jsonobj.put("status", "created");
        jsonobj.put("teamSize", 0);
        jsonobj.put("projectName", "MeeMumbaiKar");

        given()
            .contentType(ContentType.JSON)
            .body(jsonobj)
        .when()
            .post("http://49.249.28.218:8091/addProject")
        .then()
            .assertThat().statusCode(201)
            .log().all();
    
}}
