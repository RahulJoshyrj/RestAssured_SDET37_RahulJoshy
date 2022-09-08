package reqresAssignments;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class GetOperationInReqres {
	@Test
	public void getOperation() {
		baseURI="https://reqres.in";
		
		given()
		.contentType(ContentType.JSON)
		.when()
		.get("/api/unknown/520")
		.then()
		.assertThat().statusCode(200)
		.log().all();
		
	}
	

}
