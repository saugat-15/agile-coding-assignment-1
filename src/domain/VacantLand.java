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

	public VacantLand() {
		System.out.println("Not implemented yet");
	}
	public String[] getOverlays() {
		return overlays;
	}
	public void setOverlays(String[] overlays) {
		this.overlays = overlays;
	}
	@Override
	public double calculateExtraServices() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void setUpExtraServices() {
		// TODO Auto-generated method stub
		
	}

}
