package Assertion_Validations;
import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import  java.util.Collection;
import java.util.List;
public class dynamicResponseValidationGet {
	@Test
	public void dynamicValidation() {
		String expData="TY_PROJ_2205";
		baseURI="http://localhost";
		port=8084;
		
		Response response = when().get("/projects");
		List<String> projectID = response.jsonPath().get("projectId");
		boolean flag=false;
		for(String actualID:projectID) {
			
			if(actualID.equalsIgnoreCase(expData)) {
				flag=true;
				System.out.println("project is matching");
			}
		}
		
		Assert.assertTrue(flag);
		System.out.println("data verfied");
		
		response.then().log().all();
		
	}

}
