package crudOperationwithBDD;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class deleteProject {
	@Test
 public void delete() {
		given()
		.when()
		.delete("http://localhost:8084/projects/TY_PROJ_1409")
		.then()
		.assertThat().statusCode(204)
		.assertThat().log().all();
		
	 
 }
}
