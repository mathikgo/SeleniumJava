package leadspages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.LeafTapsWrappers;

public class Login extends LeafTapsWrappers{
	
	public Login(RemoteWebDriver driver,ExtentTest test){
		this.driver=driver;
		this.test=test;
		System.out.println(driver.getTitle());
		if(!verifyTitle("Opentaps Open Source ERP + CRM")){
			reportStep("This is NOT login Page", "FAIL");
		}
	}
	
	public Login typeUserName(String data){
		enterById("username", data);
		return this;
	}
	
	public Login typePassword(String data){
		enterById("password", data);
		return this;
	}
	
	public Home clickLogin(){
		clickByClassName("decorativeSubmit");
		return new Home(driver,test);
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
