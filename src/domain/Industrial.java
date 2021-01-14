package domain;

/**
 * @author TAKeogh
 * created 29-Nov-2020 8:30:00am.
 * @version 1.0.
 * Concrete class of Property abstract class.
 *
 */
public class Industrial extends Property {

	private String hazardStatus;
	private String heavyVehicleStatus;
	private static final double CIV_RATE = 0.004;
	private static final int INDUSTRIAL_WASTE_DISPOSAL_UNITS = 4;
	private static final double INDUSTRIAL_WASTE_DISPOSAL_FEES = 600.00;
	private static final double FIRE_SERVICES_BASE = 200;
	private static final double FIRE_SERVICES_PERCENT = 0.00007;
	private ServiceType industrialWasteDisposal;
	private ServiceType fireServicesLevy;
	
	
	public Industrial() {
		this.setHazardStatus("Biological");
		this.setHeavyVehicleStatus("Parked");
		setCapitalImprovedRate(CIV_RATE);
	}

	public String getHazardStatus() {
		return hazardStatus;
	}

	public void setHazardStatus(String hazardStatus) {
		this.hazardStatus = hazardStatus;
	}

	public String getHeavyVehicleStatus() {
		return heavyVehicleStatus;
	}

	public void setHeavyVehicleStatus(String heavyVehicleStatus) {
		this.heavyVehicleStatus = heavyVehicleStatus;
	}
	
	@Override
	public double calculateExtraServices() {
		return industrialWasteDisposal.calculateChargeForServiceType() +
				   fireServicesLevy.calculateChargeForServiceType();
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
	public String toString() {
		return  super.toString() + "Industrial [\n" + 
									industrialWasteDisposal.toString() + "\n" +
									fireServicesLevy.toString() + " ]\n ";
	}
		
	}

	
