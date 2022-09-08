package EndTOEND;
import static io.restassured.RestAssured.*;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.crm.genericUtilities.DataBaseUtility;
import com.crm.genericUtilities.FileUtility;
import com.crm.genericUtilities.Iconstants;
import com.crm.genericUtilities.JavaUtility;
import com.crm.genericUtilities.endPointsLibrary;

import POJOClass.PostProjectsPOJOClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
@Test
public class endToEndScenario {

	public void EndTOEndScenarioTest() throws Throwable {
		baseURI="http://localhost";
		port=8084;
		JavaUtility jLib=new JavaUtility();
		PostProjectsPOJOClass pojo=new PostProjectsPOJOClass("qwerty","cloudNINE"+jLib.getRandomNumber(),"Created",60);
		
		Response response = given().body(pojo).contentType(ContentType.JSON)
		.when().post(endPointsLibrary.createProject);
		String projectId= response.body().jsonPath().get("projectId");
		System.out.println(projectId);
		response.then().assertThat().statusCode(201).assertThat().contentType(ContentType.JSON).log().all();

		
		FileUtility fLib=new FileUtility();
		String url=fLib.getPropertKeyValue("url");
		String username=fLib.getPropertKeyValue("username");
		String password=fLib.getPropertKeyValue("password");
		
		WebDriverManager.chromedriver().create();
		WebDriver driver=new ChromeDriver();
		driver.get(url);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='usernmae']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[.='Projects']")).click();
		Thread.sleep(2000);
		List<WebElement> ProjectIDs = driver.findElements(By.xpath("//tr//td[1]"));
		
		for(WebElement projId:ProjectIDs) {
			if(projId.getText().equalsIgnoreCase(projectId)) {
				System.out.println("project has been created");
			}
			
		}
		
		DataBaseUtility dLib=new DataBaseUtility();
		dLib.connectDB();
		String delete="delete from project where project_id="+"'"+projectId+"'";
		dLib.executeUpdate(delete);
		
		driver.get(url);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='usernmae']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[.='Projects']")).click();
		Thread.sleep(2000);
		List<WebElement> ProjIDs = driver.findElements(By.xpath("//tr//td[1]"));
		boolean flag=true;
		for(WebElement projId:ProjIDs) {
			if(projId.getText().equalsIgnoreCase(projectId)) {
				flag=false;
			}
			else {
				flag=true;
			}
			
		}
		if(flag=true) {
			System.out.println("project was deleted");
		}
		
		driver.close();
	 }
}
			 
		 
	


