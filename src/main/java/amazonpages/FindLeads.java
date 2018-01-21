package leadspages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LeafTapsWrappers;

public class FindLeads extends LeafTapsWrappers{
	
	public FindLeads(RemoteWebDriver driver,ExtentTest test){
		this.driver=driver;
		this.test=test;
		if(!verifyTitle("Find Leads | opentaps CRM")){
			reportStep("This is NOT Find Leads Page", "FAIL");
		}
	}
			
	public FindLeads inputFirstname(String data){
		enterByXpath("(//input[@name='firstName'])[3]", data);
		return this;
	}
	
	public FindLeads clickPhone(){
		clickByXpath("(//span[@class='x-tab-strip-text '])[2]");
		return this;
	}
	
	public FindLeads clickEmail(){
		clickByXpath("(//span[@class='x-tab-strip-text '])[3]");
		return this;
	}
	
	public FindLeads inputPhoneNo(String data){
		enterByName("phoneNumber", data);
		return this;
	}
	
	public FindLeads inputEmail(String data){
		enterByName("emailAddress", data);
		return this;
	}
	public FindLeads inputLeadID(String data){
		enterByName("id", data);
		return this;
	}
	
	public FindLeads clickFindLeadsButton(){
		clickByXpath("//button[text()='Find Leads']");
		return this;
	}
	
	public String captureLeadID() throws InterruptedException{
		Thread.sleep(3000);
		return getTextByXpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a");
	}
	
	public FindLeads captureLeadFirstName() throws InterruptedException{
		Thread.sleep(3000);
		leadName = getTextByXpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a");
		return this;
	}
	
	public ViewLead clickFirstRow() throws InterruptedException{
		Thread.sleep(3000);
		clickByXpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a");
		return new ViewLead(driver,test);
	}
	
	public FindLeads verifyErrorMsg(String data) throws InterruptedException{
		String strErrMsg = getTextByXpath("//div[text()='No records to display']");
		System.out.println(strErrMsg);
		Thread.sleep(1000);
		if(strErrMsg.contains(data))	
			reportStep("Error message:" + strErrMsg + " is displayed and verified", "PASS");
		else
			reportStep("Error message:" + strErrMsg + " is displayed and it is not correct", "FAIL");
			 
		return this;
	}
}
