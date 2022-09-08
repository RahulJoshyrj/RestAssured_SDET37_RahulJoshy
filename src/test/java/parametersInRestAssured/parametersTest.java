package parametersInRestAssured;
import static io.restassured.RestAssured.*;

public class parametersTest {
	public void params() {
	baseURI="http://api.github.com";
	port=8084;
	
	given()
	.pathParam("username", "RahulJoshyrj")
	.queryParam("per_page", 30)
	.queryParam("page", 1)
	.when().get("user/{username}/repos")
	.then().assertThat().statusCode(200).log().all();
	
	
}
}
