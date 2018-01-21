package leadspages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LeafTapsWrappers;

public class EditLead extends LeafTapsWrappers{
	
	public EditLead(RemoteWebDriver driver,ExtentTest test){
		this.driver=driver;
		this.test=test;
		if(!verifyTitleContainsText("opentaps CRM")){
			reportStep("This is NOT Edit Leads Page", "FAIL");
		}
	}
			
	public EditLead changeCompanyname(String data){
		enterById("updateLeadForm_companyName", data);
		return this;
	}
	
	public ViewLead clickUpdateButton(){
		clickByXpath("(//input[@name='submitButton'])[1]");
		return new ViewLead(driver,test);
	}

}
