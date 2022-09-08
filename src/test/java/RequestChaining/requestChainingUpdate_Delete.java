package RequestChaining;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.crm.genericUtilities.JavaUtility;
import static io.restassured.RestAssured.*;

import POJOClass.PostProjectsPOJOClass;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class requestChainingUpdate_Delete {
	@Test
	public void requestChaining() {
		JavaUtility jLib=new JavaUtility();
		JSONObject obj=new JSONObject();
		obj.put("createdBy", "RahulJoshy");
		obj.put("projectName", "Warrior"+jLib.getRandomNumber());
		obj.put("status", "On Going");
		obj.put("teamSize", 15);
		baseURI="http://localhost";
		port=8084;
		 Response response = given().body(obj).contentType(ContentType.JSON).when().put("/projects/TY_PROJ_2205	");
		String projId = response.jsonPath().get("projectId");
		System.out.println(projId);
		response.then().log().all();
		
		given().pathParam("projId", projId).when().get("/projects/{projId}").then().assertThat().statusCode(200).log().all();
	}
}
