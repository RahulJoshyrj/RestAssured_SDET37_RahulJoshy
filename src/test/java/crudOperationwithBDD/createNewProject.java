package crudOperationwithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class createNewProject {
	@Test
 public void create() {
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "RahulJoshy");
		jobj.put("projectName", "RestAssuredApi");
		jobj.put("status", "onGoing");
		jobj.put("teamSize", "20");
		
		given()
		.contentType(ContentType.JSON)
		.body(jobj)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().statusCode(201)
		.assertThat().contentType(ContentType.JSON)
		.assertThat().log().all();
		
		
	 
 }
}
