package domain;

/**
 * @author TAKeogh
 * created 29-Nov-2020 8:30:00am.
 * @version 1.0
 *
 */

public class Community extends Property{
	private String category;
	private static final double CIV_RATE = 0.025;
	private static final int WASTE_MANAGEMENT_UNITS = 1;
	private static final double WASTE_MANAGEMENT_FEES = 400.00;
	private static final int GREEN_WASTE_MANAGEMENT_UNITS = 1;
	private static final double GREEN_WASTE_MANAGEMENT_FEES = 90.00;
	private static final double FIRE_SERVICES_BASE = 100;
	private static final double FIRE_SERVICES_PERCENT = 0.00007;
	private static final int TRAFFIC_MANAGEMENT_LEVY_UNITS = 1;
	private static final double TRAFFIC_MANAGEMENT_LEVY_FEES = 200.00;
	private ServiceType wasteManagement;
	private ServiceType greenWasteManagement;
	private ServiceType fireServicesLevy;
	private ServiceType trafficManagementLevy;
	
	public Community() {
		super();
		this.setCategory("Cultural");
		setCapitalImprovedRate(CIV_RATE);
	}	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public double calculateExtraServices() {
		return wasteManagement.calculateChargeForServiceType() +
				   greenWasteManagement.calculateChargeForServiceType() +
				   fireServicesLevy.calculateChargeForServiceType() +
				   trafficManagementLevy.calculateChargeForServiceType();
		}


	@Override
	public void setUpExtraServices() {
		wasteManagement = new UnitAndRateService("Waste Management",
				  WASTE_MANAGEMENT_UNITS,
				  WASTE_MANAGEMENT_FEES);
		greenWasteManagement = new UnitAndRateService("Green Waste Management",
				  GREEN_WASTE_MANAGEMENT_UNITS,
				  GREEN_WASTE_MANAGEMENT_FEES);
		fireServicesLevy = new BaseAndPercentageOfValueService("Fire Levy",
																FIRE_SERVICES_BASE,
																FIRE_SERVICES_PERCENT,
																getCapitalImprovedValue());
		trafficManagementLevy = new UnitAndRateService("Industrial Waste Disposal",
				  TRAFFIC_MANAGEMENT_LEVY_UNITS,
				  TRAFFIC_MANAGEMENT_LEVY_FEES);
				
	}
	
	@Override
	public String toString() {
		return  super.toString() + "Community [\n" + 
				wasteManagement.toString() + "\n" +
				greenWasteManagement.toString() + "\n" +
				fireServicesLevy.toString() + " ]\n " +
				trafficManagementLevy.toString() + " ]\n ";
	}

}
