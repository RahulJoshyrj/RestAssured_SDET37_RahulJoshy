package DifferentWaysToPostRequest;

import POJOClass.PostProjectsPOJOClass;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class postProjectUsingPojoCLass {
	@Test
	public void postUsingPojo() {
		PostProjectsPOJOClass pojo=new PostProjectsPOJOClass("Rahul Joshy","new api","created",20);
		given()
		.contentType(ContentType.JSON)
		.body(pojo)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().statusCode(201)
		.assertThat().contentType(ContentType.JSON)
		.assertThat().log().all();
		
	}
	
	
		

}
