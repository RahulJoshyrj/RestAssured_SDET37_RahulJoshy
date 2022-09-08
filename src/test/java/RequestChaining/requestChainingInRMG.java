package RequestChaining;

import com.crm.genericUtilities.JavaUtility;
import static io.restassured.RestAssured.*;

import POJOClass.PostProjectsPOJOClass;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class requestChainingInRMG {
 public void requestChaining() {
	 JavaUtility jLib=new JavaUtility();
	 PostProjectsPOJOClass pojo=new PostProjectsPOJOClass("RahulJoshy","brave"+jLib.getRandomNumber(),"completed",
	 25);
	 baseURI="http://localhost";
	 port=8084;
	 
	  Response response = given().body(pojo).contentType(ContentType.JSON)
			  .when().post("/addProject");
	  
	  String projId=response.jsonPath().get("projectId");
	  System.out.println(projId);
	  response.then().log().all();
	  
	  
	  given()
	  .pathParam("pid", projId)
	  .when().get("/projects/{pid}")
	  .then().assertThat().statusCode(200).log().all();
			 
	 
 }
}
