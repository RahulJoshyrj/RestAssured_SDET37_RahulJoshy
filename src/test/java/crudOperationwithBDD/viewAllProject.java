package crudOperationwithBDD;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class viewAllProject {
	@Test
	public void getAll() {
		given()
		.contentType(ContentType.JSON)
		.when()
		.get("http://localhost:8084/projects")
		.then()
		.assertThat().statusCode(200)
		.assertThat().contentType(ContentType.JSON)
		.assertThat().log().all();
		
	}

}
