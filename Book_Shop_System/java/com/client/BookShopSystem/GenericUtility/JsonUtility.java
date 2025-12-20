package com.client.BookShopSystem.GenericUtility;
import static io.restassured.RestAssured.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import org.json.simple.parser.ParseException;

import com.jayway.jsonpath.JsonPath;

import io.restassured.response.Response;
public class JsonUtility {


		
		FileUtility fu=new FileUtility();
		//get the jsonData from based on Json complex xpath
		public String getDataOnJsonPath(Response resp,String jsonXpath) throws FileNotFoundException, IOException, ParseException
		{
			List<Object> list = JsonPath.read(resp.asString(), jsonXpath);
			return list.get(0).toString();	
		}
		//	  get the xmlData from based on xml complex xpath

		public String getDataOnXpath(Response resp,String xmlXpath) {
			return resp.xmlPath().get(xmlXpath);		
		}
		
		public boolean verifyDataOnJsonPath(Response resp,String jsonnXpath,String expectedData) {
			List<String> list = JsonPath.read(resp.asString(), expectedData);
			boolean flag=false;
			for(String str:list) {
				if(str.equals(expectedData)) {
					System.out.println(expectedData+"is available===PASS");
					flag=true;
				}
			}
			if(flag==false) {
				System.out.println(expectedData+"is available===PASS");
			}
			return flag;
		}
		
		public String getaccessToken() throws IOException {
			Response resp = given()
			   .formParam("client_id",fu.getDataFromPropertyFile("clientID"))
			   .formParam("client_secret", fu.getDataFromPropertyFile("clientSecret"))
			   .formParam("grant_type", fu.getDataFromPropertyFile("grantType"))
			   .when()
			   .post("http://49.249.28.218:8180/auth/realms/ninza/protocol/openid-connect/token");
			resp.then().log().all();
			//capture data from the response
			String token = resp.jsonPath().get("access_token");
			return token;
			
		}

	}


