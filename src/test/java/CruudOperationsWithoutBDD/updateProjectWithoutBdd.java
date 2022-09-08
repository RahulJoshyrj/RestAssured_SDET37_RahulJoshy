package CruudOperationsWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class updateProjectWithoutBdd {
	@Test
	public void updateProject() {
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy","whitewolf");
		jobj.put("projectName","WhitewolfProject2");
		jobj.put("status","ongoing");
		jobj.put("teamSize","20");
		RequestSpecification reqspec = RestAssured.given();
		reqspec.contentType(ContentType.JSON);
		reqspec.body(jobj);
		Response response = reqspec.put("http://localhost:8084/projects/TY_PROJ_1603");
		ValidatableResponse validate = response.then();
//		validate.assertThat().statusCode(200);
		validate.assertThat().contentType(ContentType.JSON);
		validate.log().all();
		
		
	}

}
