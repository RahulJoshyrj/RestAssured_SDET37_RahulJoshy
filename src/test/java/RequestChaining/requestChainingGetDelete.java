package RequestChaining;
import static io.restassured.RestAssured.*;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class requestChainingGetDelete {
	@Test
	public void getDelete() {
		baseURI="http://localhost";
		port=8084;
		String actualPID="TY_PROJ_2204";
		
		Response response = given().contentType(ContentType.JSON).when().get("/projects");
		List<String>projId=response.jsonPath().get("projectId");
		for(String PID:projId) {
			if(PID.equalsIgnoreCase(actualPID)) {
				given().contentType(ContentType.JSON).pathParam("PID", PID).when().delete("/projects/{PID}")
				.then().assertThat().statusCode(204).log().all();
			}
		}
	
		
	}

}
