package servicenowpages;

import wrappers.LeafTapsWrappers;

public class ListIncidents extends LeafTapsWrappers{
	
	public ListIncidents(){
		if(!verifyTitleContainsText("ServiceNow")){
			reportStep("This is NOT Incident List Page", "FAIL");
		}
		switchDefault();
		switchFrame("gsft_main");
	}
	
	public ListIncidents inputIncidentNo(String data){
		enterByXpathAndEnterKey("(//input[@class='form-control'])[1]",data);
		return this;
	}
	
	public ListIncidents clickFirstIncRow(){
		clickByXpath("//a[@class='linked formlink']");
		return this;
	}
	
	public ListIncidents selectAssignedTo(String data){
		enterByIdAndTabKey("sys_display.incident.assigned_to",data);
		return this;
	}
	
	public ListUsers clickAssignToLookup() {
		clickByIdNoSnap("lookup.incident.assigned_to");
		return new ListUsers();
	}
	
	public ListIncidents inputAssignTo(String data) {
		switchToLastWindow();
		enterByXpathAndEnterKey("(//input[@class='form-control'])[1]", data);
		
		return this;
	}
	
	public ListIncidents selectStates(String data){
		selectVisibileTextById("incident.state",data);
		return this;
	}
	
	public ListIncidents clickClosureInfo()
	{
		clickByXpath("(//span[@class='tab_caption_text'])[3]");
		return this;
	}
	
	public ListIncidents selectCloseCode(String data){
		selectVisibileTextById("incident.close_code",data);
		return this;
	}
	
	public ListIncidents inputCloseNotes(String data){
		enterById("incident.close_notes", data);
		return this;
	}
	
	public ListIncidents clearShortDesc(){
		clearById("incident.short_description");
		return this;
	}
	
	public ListIncidents inputShortDesc(String data){
		enterById("incident.short_description", data);
		return this;
	}
	public ListIncidents verifyAlert(String data) throws InterruptedException{
		Thread.sleep(5000);
		System.out.println("Alert text " +getAlertText());
		String text = getAlertText();
		/*if (text.equals(data)) {			
			reportStep("The text displayed in the alert is verified and it is " +data, "PASS");
		}
		else{
			reportStep("The text displayed in the alert is not correct and it is " +data, "FAIL");
		}*/	
		return this;
	}
	
	public ListIncidents alertAccept(){
		acceptAlert();
		return this;
	}
	
	public ListIncidents clickSubmit()
	{
		clickById("sysverb_update");
		return this;
	}
	
	public ListIncidents clickSubmitNoSnap()
	{
		clickByIdNoSnap("sysverb_update");
		return this;
	}
	public ListIncidents verifyFields(String locator, String data)
	{
		verifyTextByXpath(locator, data);
		return this;
	}
	
	public Home moveOutOfFrame(){
		switchDefault();
		return new Home();
	}
	
	
	}
	
	
	
	
	
	
	
	
	
	
	
	


