package reqresAssignments;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class deleteOperationInReqres {
	@Test
	public void deleteOperation() {
		baseURI="https://reqres.in";
		
		given()
		.contentType(ContentType.JSON)
		.when()
		.delete("/api/users/52")
		.then()
		.assertThat().statusCode(204)
		.assertThat().log().all();
		
	}
}
