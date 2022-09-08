package crudOperationwithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class updateProject {
	@Test
	public void putIntoProject(){
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "Peter Parker");
		jobj.put("projectName", "LoneWolfPRO");
		jobj.put("status", "created");
		jobj.put("teamSize", "50");
		
		given()
		.contentType(ContentType.JSON)
		.body(jobj)
		.when()
		.put("http://localhost:8084/projects/TY_PROJ_1413")
		.then()
		.assertThat().statusCode(200)
		.assertThat().contentType(ContentType.JSON)
		.assertThat().log().all();
		
		
	}
}


