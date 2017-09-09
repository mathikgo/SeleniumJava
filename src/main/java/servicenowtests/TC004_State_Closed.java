package servicenowtests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import servicenowpages.Login;
import wrappers.LeafTapsWrappers;

public class TC004_State_Closed extends LeafTapsWrappers{
	
	@BeforeClass
	public void setvalues(){
		dataSheetName="TC004";
		browserName="chrome";
		testCaseName="TC004_State_Closed";
		testDescription="Login to Service now and Assign the Incident state as Closed";
		authors="Babu";
		category="Smoke";
	}
	
	@Test(dataProvider="fetchData")
	public void assignClosedState(String username, String pwd, String filterNav, String incidentOpt, String incidentNo, String State, String alertText, String shortDesc, String incidentOpt2, String searchTxt) throws InterruptedException{
		
		new Login()
		.typeUserName(username)
		.typePassword(pwd)
		.clickLogin()
		.enterFilterNavigator(filterNav)
		.searchIncident(incidentOpt)
		.inputIncidentNo(incidentNo)
		.clickFirstIncRow()
		.selectStates(State)
		.clearShortDesc()
		.clickSubmitNoSnap()
		.verifyAlert(alertText)
		.alertAccept()
		.inputShortDesc(shortDesc)
		.clickSubmit()
		.moveOutOfFrame()
		.enterFilterNavigator(filterNav)
		.searchIncident(incidentOpt2)
		.inputIncidentNo(incidentNo)
		.verifyFields("(//tr[@class='list2_no_records']/td)", searchTxt);
	}

}
