package leadstests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import leadspages.Login;
import wrappers.LeafTapsWrappers;

public class TC005_DuplicateLead extends LeafTapsWrappers{
	
	@BeforeClass
	public void setvalues(){
		dataSheetName="TC005_DupLead";
		browserName="chrome";
		testCaseName="TC003_Duplicate Lead";
		testDescription="Login to LeafTaps and Duplicate Lead";
		authors="Babu";
		category="Smoke";
	}
	
	@Test(dataProvider="fetchData")
	public void DuplicateLead(String username, String pwd, String EmailAddr) throws InterruptedException{
		
		new Login(driver, test)
		.typeUserName(username)
		.typePassword(pwd)
		.clickLogin()
		.clickCRMSFA()
		.clickLeads()
		.clickFindLeads()
		.clickEmail()
		.inputEmail(EmailAddr)
		.clickFindLeadsButton()
		.captureLeadFirstName()
		.clickFirstRow()
		.clickDuplicateLead()
		.clickCreateLead()
		.verifyForename(leadName);
	}

}
