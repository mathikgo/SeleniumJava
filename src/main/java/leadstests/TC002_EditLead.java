package leadstests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import leadspages.Login;
import wrappers.LeafTapsWrappers;

public class TC002_EditLead extends LeafTapsWrappers{
	
	@BeforeClass
	public void setvalues(){
		dataSheetName="TC002_EL";
		browserName="chrome";
		testCaseName="TC002_Edit Lead";
		testDescription="Login to LeafTaps and update company name in Edit Lead";
		authors="Babu";
		category="Smoke";
	}
	
	@Test(dataProvider="fetchData")
	public void createLead(String username, String pwd, String foreName, String companyName) throws InterruptedException{
		
		new Login(driver, test)
		.typeUserName(username)
		.typePassword(pwd)
		.clickLogin()
		.clickCRMSFA()
		.clickLeads()
		.clickFindLeads()
		.inputFirstname(foreName)
		.clickFindLeadsButton()
		.clickFirstRow()
		.clickEdit()
		.changeCompanyname(companyName)
		.clickUpdateButton()
		.verifyCompanyname(companyName);	
	}

}
