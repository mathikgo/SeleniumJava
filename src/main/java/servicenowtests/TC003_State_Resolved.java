package servicenowtests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import servicenowpages.Login;
import wrappers.LeafTapsWrappers;

public class TC003_State_Resolved extends LeafTapsWrappers{
	
	@BeforeClass
	public void setvalues(){
		dataSheetName="TC003";
		browserName="chrome";
		testCaseName="TC003_State_Resolved";
		testDescription="Login to Service now and Assign the Incident state as Resolved";
		authors="Babu";
		category="Smoke";
	}
	
	@Test(dataProvider="fetchData")
	public void assignResolvedState(String username, String pwd, String filterNav, String incidentOpt, String incidentNo, String assignedTo, String State, String closeCode, String closeNotes){
		
		new Login()
		.typeUserName(username)
		.typePassword(pwd)
		.clickLogin()
		.enterFilterNavigator(filterNav)
		.searchIncident(incidentOpt)
		.inputIncidentNo(incidentNo)
		.clickFirstIncRow()
		.clickAssignToLookup()
		.inputSearchField(assignedTo)
		.clickFirstIncRow()
		.selectStates(State)
		.clickClosureInfo()
		.selectCloseCode(closeCode)
		.inputCloseNotes(closeNotes)
		.clickSubmit()
		.inputIncidentNo(incidentNo)
		.verifyFields("//a[@class='linked formlink']", incidentNo)
		.verifyFields("//a[@class='linked formlink']/following::td[5]", State);
	}

}
