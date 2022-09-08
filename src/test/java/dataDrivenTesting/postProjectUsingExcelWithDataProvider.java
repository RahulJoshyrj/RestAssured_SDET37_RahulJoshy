package dataDrivenTesting;
import static io.restassured.RestAssured.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.genericUtilities.ExcelUtility;
import com.crm.genericUtilities.JavaUtility;

import POJOClass.*;
import io.restassured.http.ContentType;

public class postProjectUsingExcelWithDataProvider {
	@Test(dataProvider="getData")
	public void createProjectTest(String createdBy,String projectName,String status, int teamSize ) {
		JavaUtility jLib= new JavaUtility();
		PostProjectsPOJOClass pojo=new PostProjectsPOJOClass(createdBy,projectName+jLib.getRandomNumber(),status,teamSize);
		baseURI="http://localhost";
		port=8084;
		given()
		.body(pojo)
		.contentType(ContentType.JSON)
		.when()
		.post("/addProject")
		.then()
		.assertThat().statusCode(201)
		.assertThat().contentType(ContentType.JSON)
		.log().all();
	}

@DataProvider(name="getData")
public Object[][]data(){
	ExcelUtility eLib=new ExcelUtility();
	String createdBy1 = eLib.readDataFromExcel("Sheet1",1 ,0 );
	String createdBy2=eLib.readDataFromExcel("Sheet1",2, 0);
	String createdBy3=eLib.readDataFromExcel("Sheet1", 3, 0);
	String createdBy4=eLib.readDataFromExcel("Sheet1", 4, 0);
	
	String projectName1=eLib.readDataFromExcel("Sheet1", 1, 1);
	String projectName2=eLib.readDataFromExcel("Sheet1", 2, 1);
	String projectName3=eLib.readDataFromExcel("Sheet1", 3, 1);
	String projectName4=eLib.readDataFromExcel("Sheet1", 4, 1);
	
	String status1=eLib.readDataFromExcel("Sheet1", 1, 2);
	String status2=eLib.readDataFromExcel("Sheet1", 2, 2);
	String status3=eLib.readDataFromExcel("Sheet1", 3, 2);
	String status4=eLib.readDataFromExcel("Sheet1", 4, 2);
	
	int teamSize1=eLib.readNumericValueFromExcel("Sheet1", 1, 3);
	int teamSize2=eLib.readNumericValueFromExcel("Sheet1", 2, 3);
	int teamSize3=eLib.readNumericValueFromExcel("Sheet1", 3, 3);
	int teamSize4=eLib.readNumericValueFromExcel("Sheet1", 4, 3);
	
	
	Object[][]data=new Object[4][4];
	data[0][0]=createdBy1;
	data[0][1]=projectName1;
	data[0][2]=status1;
	data[0][3]=teamSize1;
	
	data[1][0]=createdBy2;
	data[1][1]=projectName2;
	data[1][2]=status2;
	data[1][3]=teamSize2;
	
	data[2][0]=createdBy3;
	data[2][1]=projectName3;
	data[2][2]=status3;
	data[2][3]=teamSize3;
	
	data[3][0]=createdBy4;
	data[3][1]=projectName4;
	data[3][2]=status4;
	data[3][3]=teamSize4;
	
	return data;
}
}
