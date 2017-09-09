package leadspages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LeafTapsWrappers;

public class ViewLead extends LeafTapsWrappers{
	
	public ViewLead(RemoteWebDriver driver,ExtentTest test){
		this.driver=driver;
		this.test=test;
		if(!verifyTitle("View Lead | opentaps CRM")){
			reportStep("This is NOT View Lead Page", "FAIL");
		}
	}
			
	public ViewLead verifyForename(String data){
		verifyTextById("viewLead_firstName_sp", data);
		return this;
	}
	
	public ViewLead verifyCompanyname(String data){
		verifyTextContainsById("viewLead_companyName_sp", data);
		return this;
	}
	
	public MyLeads clickDelete(){
		clickByLink("Delete");
		return new MyLeads(driver, test);
	}
	
	public DuplicateLead clickDuplicateLead(){
		clickByLink("Duplicate Lead");
		return new DuplicateLead(driver, test);
	}
	
	public EditLead clickEdit(){
		clickByLink("Edit");
		return new EditLead(driver, test);
	}

	public FindLeads clickFindLeads(){
		clickByLink("Find Leads");
		return new FindLeads(driver, test);
	}
	
}
