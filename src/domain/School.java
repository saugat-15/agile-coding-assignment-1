package domain;

/**
 * @author TAKeogh
 * created 29-Nov-2020 8:30:00am.
 * @version 1.0.
 *
 */
public class School extends Property{

	private String classification;
	private static final double CIV_RATE = 0.030;
	private static final int INDUSTRIAL_WASTE_DISPOSAL_UNITS = 2;
	private static final double INDUSTRIAL_WASTE_DISPOSAL_FEES = 600.00;
	private static final double FIRE_SERVICES_BASE = 200;
	private static final double FIRE_SERVICES_PERCENT = 0.00007;
	private static final int TRAFFIC_MANAGEMENT_LEVY_UNITS = 1;
	private static final double TRAFFIC_MANAGEMENT_LEVY_FEES = 200.00;
	private ServiceType industrialWasteDisposal;
	private ServiceType fireServicesLevy;
	private ServiceType trafficManagementLevy;
	
	public School() {
		super();
		this.setClassification("Private");
		setCapitalImprovedRate(CIV_RATE);
	}
	
	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	@Override
	public double calculateExtraServices() {
		return industrialWasteDisposal.calculateChargeForServiceType() +
				   fireServicesLevy.calculateChargeForServiceType() +
				   trafficManagementLevy.calculateChargeForServiceType();
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
		trafficManagementLevy = new UnitAndRateService("Industrial Waste Disposal",
				  TRAFFIC_MANAGEMENT_LEVY_UNITS,
				  TRAFFIC_MANAGEMENT_LEVY_FEES);
				
	}
	
	@Override
	public String toString() {
		return  super.toString() + "School [\n" + 
									industrialWasteDisposal.toString() + "\n" +
									fireServicesLevy.toString() + " ]\n " +
									trafficManagementLevy.toString() + " ]\n ";
	}
	
}


