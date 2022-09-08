package DifferentWaysToPostRequest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PostProjectUsingJSONObject {
	@Test
public void postProject() {
	JSONObject jobj=new JSONObject();
	jobj.put("createdBy", "Rahul Joshy");
	jobj.put("projectName", "brandNewAPI");
	jobj.put("status", "created");
	jobj.put("teamSize", "25");
	
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
