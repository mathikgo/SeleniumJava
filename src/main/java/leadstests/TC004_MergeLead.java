package leadstests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import leadspages.Login;
import wrappers.LeafTapsWrappers;

public class TC004_MergeLead extends LeafTapsWrappers{
	
	@BeforeClass
	public void setvalues(){
		dataSheetName="TC004_ML";
		browserName="chrome";
		testCaseName="TC004_Merge Lead";
		testDescription="Login to LeafTaps and Merge two Leads";
		authors="Babu";
		category="Smoke";
	}
	
	@Test(dataProvider="fetchData")
	public void MergeLead(String username, String pwd, String fromLeadID, String toLeadID, String errMsg) throws InterruptedException{
		
		new Login(driver, test)
		.typeUserName(username)
		.typePassword(pwd)
		.clickLogin()
		.clickCRMSFA()
		.clickLeads()
		.clickMergeLeads()
		.clickSearchIcon("(//img[@alt='Lookup'])[1]")
		.inputLeadID(fromLeadID)
		.clickFindLeadsButton()
		.clickFirstResLead()
		.clickSearchIcon("(//img[@alt='Lookup'])[2]")
		.inputLeadID(toLeadID)
		.clickFindLeadsButton()
		.clickFirstResLead()
		.clickMerge()
		.alertAccept()
		.clickFindLeads()
		.inputLeadID(fromLeadID)
		.clickFindLeadsButton()
		.verifyErrorMsg(errMsg);
		
		
		
	}

}
