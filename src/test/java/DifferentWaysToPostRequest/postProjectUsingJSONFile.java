package DifferentWaysToPostRequest;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class postProjectUsingJSONFile {
	@Test
	public void postUsingJSONFile() {
		File file=new File("./src/test/resources/data.json");
		baseURI="http://localhost";
		port=8084;
		
		given()
		.body(file)
		.contentType(ContentType.JSON)
		.when()
		.post("/addProject")
		.then()
		.assertThat().statusCode(201)
		.assertThat().contentType(ContentType.JSON)
		.assertThat().log().all();
	}

}
