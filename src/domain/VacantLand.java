package domain;

/**
 * @author TAKeogh
 * created 29-Nov-2020 8:30:00am.
 * @version 1.0.
 * Concrete class of Property abstract class.
 *
 */
public class VacantLand extends Property{

	private String[] overlays;
	private static final double CIV_RATE= 0.010;
	private static final double FIRE_SERVICES_BASE = 50.00;
	private static final double FIRE_SERVICES_PERCENT = 0.00007;
	private ServiceType fireServicesLevy;
	
	public VacantLand() {
		super();
		setCapitalImprovedRate(CIV_RATE);
	}
	
	public String[] getOverlays() {
		return overlays;
	}
	
	public void setOverlays(String[] overlays) {
		this.overlays = overlays;
	}
	
	@Override
	public double calculateExtraServices() {
		return fireServicesLevy.calculateChargeForServiceType();
		
	}
	
	@Override
	public void setUpExtraServices() {
		fireServicesLevy = new BaseAndPercentageOfValueService("Fire Levy",
				FIRE_SERVICES_BASE,
				FIRE_SERVICES_PERCENT,
				getCapitalImprovedValue());
		
	}
	
	@Override
	public String toString() {
		return super.toString() + "Overlays [\n" +
								fireServicesLevy.toString() + " ]\n  ";
	}


}
