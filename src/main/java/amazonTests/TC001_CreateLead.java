package leadstests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import leadspages.Login;
import wrappers.LeafTapsWrappers;

public class TC001_CreateLead extends LeafTapsWrappers{
	
	@BeforeClass
	public void setvalues(){
		dataSheetName="TC001_CL";
		browserName="chrome";
		testCaseName="TC001_Create Lead";
		testDescription="Login to LeafTaps and Create new Lead";
		authors="Babu";
		category="Smoke";
	}
	
	@Test(dataProvider="fetchData")
	public void createLead(String username, String pwd,String companyName, String foreName, String surname, String phoneNo, String emailAddr){
		
		new Login(driver,test)
		.typeUserName(username)
		.typePassword(pwd)
		.clickLogin()
		.clickCRMSFA()
		.clickCreateLead()
		.inputCompanyName(companyName)
		.inputForename(foreName)
		.inputSurname(surname)
		.inputPhoneNo(phoneNo)
		.inputEmailAddr(emailAddr)
		.clickCreateLead()
		.verifyForename(foreName);
		
	}

}
