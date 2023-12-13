package example.google.com.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utilities.BaseTest;

public class GoogleSearchTest extends BaseTest{

	
	@BeforeMethod
	public void initialize() {
		try{
			BaseTest.createAndSetDriver();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void searchText() {
//		Write test script
	}
	
	@AfterMethod
	public void closeInstance() {
		getDriver().close();
	}
	
}
