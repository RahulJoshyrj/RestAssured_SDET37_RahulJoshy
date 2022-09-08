package parametersInRestAssured;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class PathParameter {
	@Test
	public void getSingleProject() {
		baseURI="http://localhost";
		port=8084;
		given().pathParam("pid", "TY_PROJ_2203")
		.when().get("/projects/{pid}")
		.then().log().all();
	}

}
