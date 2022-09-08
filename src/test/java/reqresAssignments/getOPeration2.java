package reqresAssignments;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class getOPeration2 {
	@Test
	public void getOperation() {
baseURI="https://reqres.in";
		
		given()
		.contentType(ContentType.JSON)
		.when()
		.get("/api/users?page=2")
		.then()
		.assertThat().statusCode(200)
		.assertThat().contentType(ContentType.JSON)
		.log().all();
		
	}

}
