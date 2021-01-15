package operation;

import java.util.Scanner;

import java.lang.String;
/**
 * @author TAKeogh
 * created 29-Nov-2020 8:30:00am.
 * @version 1.0
 * Concrete class of screen that extends FunctionalDialog and allows for the addition of a RatePayer.
 */

public class AddRatePayer extends FunctionalDialog {
	
	private String name;
	private String postalAddress;
	private int postcode;
	private int telephone;
	private String type;
	
	
	public AddRatePayer(Scanner console) {
		super(1, console);
		
		System.out.print("Enter rate player's name");
		name = console.nextLine();
		System.out.print("Enter rate player's postal address");
		postalAddress = console.nextLine();
		System.out.print("Enter rate player's postcode");
		postcode = Integer.parseInt(console.nextLine());
		System.out.print("Enter rate player's telephone number");
		telephone = Integer.parseInt(console.nextLine());
		System.out.print("Enter rate player's company type");
		type = console.nextLine();
		
	
	    
	}

	@Override
	public void obtainInput(int i) {
		System.out.println("Not implemented yet");
		setStillRunning(false);
	}

	@Override
	public void respondToInput() {
		// TODO Auto-generated method stub
		
	}

	public String getName() {
		return name;
	}


	public String getPostalAddress() {
		return postalAddress;
	}


	public int getPostcode() {
		return postcode;
	}

	public int getTelephone() {
		return telephone;
	}


	public String getType() {
		return type;
	}


}
