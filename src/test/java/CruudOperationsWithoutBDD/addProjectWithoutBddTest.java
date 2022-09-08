package CruudOperationsWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class addProjectWithoutBddTest {
	@Test
	public void create() {
		//jsonBodyCreattion
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "Rahul Joshy");
		jobj.put("projectName", "AlphaWise202");
		jobj.put("status", "created");
		jobj.put("teamSize", "25");
		//request body and contenttype
		RequestSpecification reqspec = RestAssured.given();
		reqspec.contentType(ContentType.JSON);
		reqspec.body(jobj);
		//validation
		Response response = reqspec.post("http://localhost:8084/addProject");
		ValidatableResponse validate = response.then();
		validate.assertThat().contentType(ContentType.JSON);
		validate.assertThat().statusCode(201);
		validate.log().all();
		
	}
	
	

}
