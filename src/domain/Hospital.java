package domain;

/**
 * @author TAKeogh
 * created 29-Nov-2020 8:30:00am.
 * @version 1.0
 *
 */
public class Hospital extends Property{
	
	private String status;
	private String facilities;
	private String floors;
	private static final double CIV_RATE = 0.036;
	private static final int INDUSTRIAL_WASTE_DISPOSAL_UNITS = 4;
	private static final double INDUSTRIAL_WASTE_DISPOSAL_FEES = 600.00;
	private static final double FIRE_SERVICES_BASE = 200;
	private static final double FIRE_SERVICES_PERCENT = 0.00007;
	private ServiceType industrialWasteDisposal;
	private ServiceType fireServicesLevy;
	

	public Hospital() {
		super();
		this.setStatus("Private");
		this.setFacilities("Emergency Ward");
		this.setFloors("7");
		setCapitalImprovedRate(CIV_RATE);
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status= status;
	}
	
	public String getFacilities() {
		return facilities;
	}
	
	public void setFacilities(String facilities) {
		this.facilities= facilities;
	}
	
	public String getFloors() {
		return floors;
	}
	
	public void setFloors(String floors) {
		this.floors= floors;
	}
	
	@Override
	public void setUpExtraServices() {
		industrialWasteDisposal = new UnitAndRateService("Industrial Waste Disposal",
				  INDUSTRIAL_WASTE_DISPOSAL_UNITS,
				  INDUSTRIAL_WASTE_DISPOSAL_FEES);
		fireServicesLevy = new BaseAndPercentageOfValueService("Fire Levy",
																FIRE_SERVICES_BASE,
																FIRE_SERVICES_PERCENT,
																getCapitalImprovedValue());
	}
	
	@Override
	public double calculateExtraServices() {
		
		return industrialWasteDisposal.calculateChargeForServiceType() +
			   fireServicesLevy.calculateChargeForServiceType();
	}

	@Override
	public String toString() {
		return  super.toString() + "Hospital [\n" + 
									industrialWasteDisposal.toString() + "\n" +
									fireServicesLevy.toString() + " ]\n ";
	}
	
}
