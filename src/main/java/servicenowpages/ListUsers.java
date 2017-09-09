package servicenowpages;

import wrappers.LeafTapsWrappers;

public class ListUsers extends LeafTapsWrappers{
	
	public ListUsers(){
		switchToLastWindow();
		if(!verifyTitle("Users | ServiceNow")){
			reportStep("This is NOT Users List Page", "FAIL");
		}
		//switchToLastWindow();
	}
	
	public ListUsers inputSearchField(String data){
		enterByXpathAndEnterKey("(//input[@class='form-control'])[1]",data);
		return this;
	}
	
	public ListIncidents clickFirstIncRow(){
		clickByXpathNoSnap("(//a[@class='glide_ref_item_link'])[1]");
		switchToParentWindow();
		return new ListIncidents();
	}
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	


