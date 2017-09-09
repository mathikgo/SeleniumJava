package servicenowpages;

import wrappers.LeafTapsWrappers;

public class Home extends LeafTapsWrappers{
	
	public Home(){
		if(!verifyTitleContainsText("ServiceNow")){
			reportStep("This is NOT Home Page", "FAIL");
		}
	}
	
	
	/*public Login clickLogout(){
		clickByClassName("decorativeSubmit");
		return new Login();
	}*/
	
	public Home enterFilterNavigator(String data){
		enterById("filter", data);
		return this;
	}
	
	public CreateIncident clickCreateNew(){
		clickByXpath("//a[text()='Create New']");
		return new CreateIncident();
	}
	
	public ListIncidents searchIncident(String data){
		clickByXpath("//a[text()='"+data+ "']");
		return new ListIncidents();
	}
	
	
	
	
	
	
	
	
	
	

}
