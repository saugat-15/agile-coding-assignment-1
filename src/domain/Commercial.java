package domain;

/**
 * @author TAKeogh
 * created 29-Nov-2020 8:30:00am.
 * @version 1.0
 *
 */
public class Commercial extends Property{
private String businessName;
private String abn;
private static final double CIV_RATE = 0.006;
private static final int WASTE_MANAGEMENT_UNITS = 2;
private static final double WASTE_MANAGEMENT_FEES = 400.00;
private static final double FIRE_SERVICE_BASE = 200;
private static final double FIRE_SERVICE_PERCENT = 0.00007;
private ServiceType wasteManagement;
private ServiceType fireServicesLevy;


public Commercial() {
	super();
	this.setBusinessName("Agile");
	this.setAbn("0424112");
	setCapitalImprovedRate(CIV_RATE);
		
	}
	
	public String getBusinessname() {
		return businessName;
	}
	
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	
	public String getAbn() {
		return abn;
	}
	
	public void setAbn(String abn) {
		this.abn = abn;
	}
	
	@Override
	public void setUpExtraServices() {
		wasteManagement = new UnitAndRateService("Waste Management",
				WASTE_MANAGEMENT_UNITS,
				WASTE_MANAGEMENT_FEES);
		fireServicesLevy = new BaseAndPercentageOfValueService("Fire Levy",
				FIRE_SERVICE_BASE,
				FIRE_SERVICE_PERCENT,
				getCapitalImprovedValue());
	}
	
	@Override
	public double calculateExtraServices() {
		
		return wasteManagement.calculateChargeForServiceType() +
			fireServicesLevy.calculateChargeForServiceType();
	}
	
	@Override
	public String toString() {
		return super.toString() + "Commercial [\n" +
								wasteManagement.toString() + "\n" +
								fireServicesLevy.toString() + " ]\n ";
	}
}


