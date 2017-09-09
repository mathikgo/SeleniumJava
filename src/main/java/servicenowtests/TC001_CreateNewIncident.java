package servicenowtests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import servicenowpages.Login;
import wrappers.LeafTapsWrappers;

public class TC001_CreateNewIncident extends LeafTapsWrappers{
	
	@BeforeClass
	public void setvalues(){
		dataSheetName="TC001";
		browserName="chrome";
		testCaseName="TC001_Create Incident";
		testDescription="Login to Servicenow and Create new Incident";
		authors="Babu";
		category="Smoke";
	}
	
	@Test(dataProvider="fetchData")
	public void createNewIncident(String username, String pwd,String filterNav, String callerID, String shortDesc){
		
		new Login()
		.typeUserName(username)
		.typePassword(pwd)
		.clickLogin()
		.enterFilterNavigator(filterNav)
		.clickCreateNew()
		.printIncidentNo()
		.selectCallerID(callerID)
		.enterShortDesc(shortDesc)
		.clickSubmit();
		
		
		
		
	}

}
