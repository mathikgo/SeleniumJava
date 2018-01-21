package leadspages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LeafTapsWrappers;

public class Home extends LeafTapsWrappers{
	
	public Home(RemoteWebDriver driver, ExtentTest test){
		this.driver=driver;
		this.test=test;
		if(!verifyTitle("Opentaps Open Source ERP + CRM")){
			reportStep("This is NOT Home Page", "FAIL");
		}
	}
		
	public Home clickCRMSFA(){
		clickByLink("CRM/SFA");
		return this;
	}
	
	public CreateLead clickCreateLead(){
		clickByLink("Create Lead");
		return new CreateLead(driver, test);
	}
	
	public MyLeads clickLeads(){
		clickByLink("Leads");
		return new MyLeads(driver,test);
	}
	
	
	
	
}
