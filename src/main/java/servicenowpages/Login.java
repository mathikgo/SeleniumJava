package servicenowpages;

import wrappers.LeafTapsWrappers;

public class Login extends LeafTapsWrappers{
	
	public Login(){
		System.out.println(driver.getTitle());
		if(!verifyTitle("ServiceNow")){
			reportStep("This is NOT login Page", "FAIL");
		}
		switchDefault();
		switchFrame("gsft_main");
	}
	
	public Login typeUserName(String data){
		enterById("user_name", data);
		return this;
	}
	
	public Login typePassword(String data){
		enterById("user_password", data);
		return this;
	}
	
	public Home clickLogin(){
		clickById("sysverb_login");
		return new Home();
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
