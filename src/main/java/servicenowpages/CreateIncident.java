package servicenowpages;

import wrappers.LeafTapsWrappers;

public class CreateIncident extends LeafTapsWrappers{
	
	public CreateIncident(){
		if(!verifyTitleContainsText("ServiceNow")){
			reportStep("This is NOT Create Incident Page", "FAIL");
		}
		switchDefault();
		switchFrame("gsft_main");
	}
			
	public CreateIncident printIncidentNo(){
		System.out.println("Incident no is " +getAttributeValueById("incident.number", "value"));
		return this;
	}
	
	public CreateIncident selectCallerID(String data)
	{
		enterByIdAndTabKey("sys_display.incident.caller_id",data);
		return this;
	}
	
	public CreateIncident enterShortDesc(String data)
	{
		enterById("incident.short_description", data);
		return this;
	}
	
	public ListIncidents clickSubmit()
	{
		clickById("sysverb_insert");
		return new ListIncidents();
	}
	
	
	
	
	
	
	
	
	
	

}
