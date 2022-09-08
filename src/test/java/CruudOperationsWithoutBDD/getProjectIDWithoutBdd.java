package CruudOperationsWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class getProjectIDWithoutBdd {
	@Test
	public void getProjectId() {
		RequestSpecification reqspec = RestAssured.given();
		reqspec.contentType(ContentType.JSON);
		Response response = reqspec.get("http://localhost:8084/projects/TY_PROJ_1413");
		ValidatableResponse validate = response.then();
		validate.assertThat().statusCode(200);
		validate.assertThat().contentType(ContentType.JSON);
		validate.log().all();
		
		
		
	}

}
