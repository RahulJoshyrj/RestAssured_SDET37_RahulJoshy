package EndTOEND;
 import static io.restassured.RestAssured.*;

import java.sql.ResultSet;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.genericUtilities.DataBaseUtility;
import com.crm.genericUtilities.FileUtility;
import com.crm.genericUtilities.JavaUtility;
import com.crm.genericUtilities.endPointsLibrary;

import POJOClass.PostProjectsPOJOClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class EndToEndScenario_Two
{
	@Test
	public void endToendTest() throws Throwable {
	baseURI="http://localhost";
	port=8084;
	JavaUtility jLib=new JavaUtility();
	PostProjectsPOJOClass pojo=new PostProjectsPOJOClass("SDET","Oblivion"+jLib.getRandomNumber(),"Created",25);
	
	Response response = given().body(pojo).contentType(ContentType.JSON)
	.when().post(endPointsLibrary.createProject);
	String projectId=response.body().jsonPath().get("projectId");
	System.out.println(projectId);
	response.then().assertThat().statusCode(201).assertThat().contentType(ContentType.JSON).log().all();
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	FileUtility fLib=new FileUtility();
	String url=fLib.getPropertKeyValue("url");
	String username=fLib.getPropertKeyValue("username");
	String password=fLib.getPropertKeyValue("password");
	driver.get(url);
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@id='usernmae']")).sendKeys(username);
	driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
	driver.findElement(By.xpath("//button[@type='submit']")).click();	
	Thread.sleep(2000);
	driver.findElement(By.xpath("//a[.='Projects']")).click();
	
	List<WebElement> ProjectIDs = driver.findElements(By.xpath("//tr//td[1]"));
	for(WebElement projId:ProjectIDs) {
		if(projId.getText().contentEquals(projectId)) {
			System.out.println("project created successfully");
		}
	}
	String createdBy="SDET"+jLib.getRandomNumber();
	PostProjectsPOJOClass obj=new PostProjectsPOJOClass(createdBy, "Dragon"+jLib.getRandomNumber(), "On Going", 30);
	
	Response newresponse = given().body(obj).contentType(ContentType.JSON).pathParam("projId", projectId)
	.when().put(endPointsLibrary.updateProject+"{projId}");
	String creator=newresponse.body().jsonPath().get("createdBy");
	System.out.println(creator);
	
	
	driver.get(url);
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@id='usernmae']")).sendKeys(username);
	driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//a[.='Projects']")).click();
	
	List<WebElement> ProjectManagers = driver.findElements(By.xpath("//tr//td[4]"));
	for(WebElement projMan:ProjectManagers) {
		if(projMan.getText().equalsIgnoreCase(creator)) {
			System.out.println("project has been updated");
		}
	}
	driver.close();
	
	DataBaseUtility dLib=new DataBaseUtility();
	dLib.connectDB();
	String query="select* from project where created_by="+"'"+creator+"'";
	ResultSet result = dLib.executeQuery(query);
	boolean flag=false;
	while(result.next()) {
		System.out.println(result.getString(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4)+"\t"+result.getString(5)+"\t"+result.getInt(6));
		flag=true;
	}
	if(flag=true) {
		System.out.println("project updated successfully");
	}

	
	
}
}
