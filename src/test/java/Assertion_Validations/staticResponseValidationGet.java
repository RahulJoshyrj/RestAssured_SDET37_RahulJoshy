package Assertion_Validations;
import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
public class staticResponseValidationGet {
	@Test
	public void staticvalidationGet() {
		String expData="TY_PROJ_1407";
		baseURI="http://localhost";
		port=8084;
		
		Response response = when().get("/projects");
		
		String actData=response.jsonPath().get("[16].projectId");
		Assert.assertEquals(expData, actData);
		System.out.println("data verified");
		response.then().log().all();
	}
}
