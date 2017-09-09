package leadspages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LeafTapsWrappers;

public class CreateLead extends LeafTapsWrappers{
	
	public CreateLead(RemoteWebDriver driver, ExtentTest test){
		this.driver=driver;
		this.test=test;
		if(!verifyTitle("Create Lead | opentaps CRM")){
			reportStep("This is NOT Create Lead Page", "FAIL");
		}
	}
			
	public CreateLead inputCompanyName(String data){
		enterById("createLeadForm_companyName", data);
		return this;
	}
	
	public CreateLead inputForename(String data){
		enterById("createLeadForm_firstName", data);
		return this;
	}
	
	public CreateLead inputSurname(String data){
		enterById("createLeadForm_lastName", data);
		return this;
	}
	
	public CreateLead inputPhoneNo(String data){
		enterById("createLeadForm_primaryPhoneNumber", data);
		return this;
	}
	
	public CreateLead inputEmailAddr(String data){
		enterById("createLeadForm_primaryEmail", data);
		return this;
	}
	
	public ViewLead clickCreateLead(){
		clickByClassName("smallSubmit");
		return new ViewLead(driver,test);
	}
	
	
	
	
	
	
	
	
	
	
	

}
