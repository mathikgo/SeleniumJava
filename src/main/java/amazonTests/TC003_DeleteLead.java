package leadstests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import leadspages.FindLeads;
import leadspages.Login;
import wrappers.LeafTapsWrappers;

public class TC003_DeleteLead extends LeafTapsWrappers{
	
	@BeforeClass
	public void setvalues(){
		dataSheetName="TC003_DelLead";
		browserName="chrome";
		testCaseName="TC003_Delete Lead";
		testDescription="Login to LeafTaps and Delete Lead";
		authors="Babu";
		category="Smoke";
	}
	
	@Test(dataProvider="fetchData")
	public void DeleteLead(String username, String pwd, String phoneNo, String errorMsg) throws InterruptedException{
		
		String leaId = new Login(driver, test)
		.typeUserName(username)
		.typePassword(pwd)
		.clickLogin()
		.clickCRMSFA()
		.clickLeads()
		.clickFindLeads()
		.clickPhone()
		.inputPhoneNo(phoneNo)
		.clickFindLeadsButton()
		.captureLeadID();
		
	//	Window win = driver.manage().window();
		
		new FindLeads(driver, test)
		.clickFirstRow()
		.clickDelete()
		.clickFindLeads()
		.inputLeadID(leaId)
		.clickFindLeadsButton()
		.verifyErrorMsg(errorMsg);
		}

}
