package parametersInRestAssured;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class QueryParameters {
 @Test
 public void queryParameter() {
	 baseURI="https:reqres.in";
	 port=8084;
	 given().queryParam("page", 3)
	 .when().get("/api/users")
	 .then().log().all();
			 
 }
}
