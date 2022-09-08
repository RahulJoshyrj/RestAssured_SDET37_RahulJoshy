package RequestChaining;

import com.crm.genericUtilities.JavaUtility;

import POJOClass.PostProjectsPOJOClass;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class requestChainingPostDelete {
	@Test
	public void requestChaining() {
		JavaUtility jLib=new JavaUtility();
		PostProjectsPOJOClass pojo=new PostProjectsPOJOClass("ANU","KingSlayer"+jLib.getRandomNumber(),"created",50);
		baseURI="http://localhost";
		port=8084;
		 Response response = given().body(pojo).contentType(ContentType.JSON)
				  .when().post("/addProject");
		  
		  String projId=response.jsonPath().get("projectId");
		  System.out.println(projId);
		  response.then().log().all();
		
		
		
		given().contentType(ContentType.JSON).pathParam("projId", projId).when().delete("/projects/{projId}")
		.then().assertThat().statusCode(204).log().all();
	
		
		
	}

}
