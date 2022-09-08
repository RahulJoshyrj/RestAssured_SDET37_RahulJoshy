package CruudOperationsWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class deleteProjectWithoutBDD {
	@Test
	public void deleteProject() {
		RequestSpecification reqspec = RestAssured.given();
		reqspec.contentType(ContentType.JSON);
		Response response = reqspec.delete("http://localhost:8084/projects/TY_PROJ_1010");
		ValidatableResponse validate = response.then();
		validate.assertThat().statusCode(204);
		validate.log().all();

	}

}
