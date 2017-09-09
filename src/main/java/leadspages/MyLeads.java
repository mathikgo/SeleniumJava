package leadspages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LeafTapsWrappers;

public class MyLeads extends LeafTapsWrappers{
	
	public MyLeads(RemoteWebDriver driver,ExtentTest test){
		this.driver=driver;
		this.test=test;
		if(!verifyTitle("My Leads | opentaps CRM")){
			reportStep("This is NOT My Leads Page", "FAIL");
		}
	}
		
	public FindLeads clickFindLeads(){
		clickByLink("Find Leads");
		return new FindLeads(driver, test);
	}
	
	public MergeLeads clickMergeLeads(){
		clickByLink("Merge Leads");
		return new MergeLeads(driver, test);
	}	

}
