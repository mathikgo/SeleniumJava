package leadspages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LeafTapsWrappers;

public class MergeLeads extends LeafTapsWrappers{
	
	public MergeLeads(RemoteWebDriver driver,ExtentTest test){
		this.driver=driver;
		this.test=test;
		if(!verifyTitle("Merge Leads | opentaps CRM")){
			reportStep("This is NOT Merge Leads Page", "FAIL");
		}
	}
		
	public MergeLeads clickSearchIcon(String data){
		clickByXpath(data);
		return this;
	}
	
	public MergeLeads inputLeadID(String data){
		switchToLastWindow();
		enterById("ext-gen25", data);		
		return this;
	}
	
	public MergeLeads clickFindLeadsButton(){
		clickByXpath("//button[contains(text(),'Find Leads')]");
		return this;
	}
	
	public MergeLeads clickFirstResLead() throws InterruptedException{
		Thread.sleep(3000);
		clickByXpathNoSnap("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a");
		switchToParentWindow();
		return this;
	}
	
	public MergeLeads clickMerge(){
		clickByLinkNoSnap("Merge");
		return this;
	}
	
	public ViewLead alertAccept() throws InterruptedException{
		Thread.sleep(3000);
		acceptAlert();
		return new ViewLead(driver,test);
	}
}

