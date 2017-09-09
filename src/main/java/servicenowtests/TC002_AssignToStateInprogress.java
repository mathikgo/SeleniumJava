package servicenowtests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import servicenowpages.Login;
import wrappers.LeafTapsWrappers;

public class TC002_AssignToStateInprogress extends LeafTapsWrappers{
	
	@BeforeClass
	public void setvalues(){
		dataSheetName="TC002";
		browserName="chrome";
		testCaseName="TC002_Assign To_State_Progress";
		testDescription="Login to Service now and Assign the Incident state as In Progress";
		authors="Babu";
		category="Smoke";
	}
	
	@Test(dataProvider="fetchData")
	public void assignInprogressState(String username, String pwd, String filterNav, String incidentOpt1, String incidentNo, String assignedTo, String States, String incidentOpt2){
		
		new Login()
		.typeUserName(username)
		.typePassword(pwd)
		.clickLogin()
		.enterFilterNavigator(filterNav)
		.searchIncident(incidentOpt1)
		.inputIncidentNo(incidentNo)
		.clickFirstIncRow()
		.selectAssignedTo(assignedTo)
		.selectStates(States)
		.clickSubmit()
		.moveOutOfFrame()
		.searchIncident(incidentOpt2)
		.inputIncidentNo(incidentNo)
		.verifyFields("//a[@class='linked formlink']/following::td[5]", States)
		.verifyFields("(//a[@class='linked'])[2]", assignedTo);		
		
	}

}
