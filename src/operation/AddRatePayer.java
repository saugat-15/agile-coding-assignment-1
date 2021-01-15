package operation;

import java.util.Scanner;

import domain.RatePayer;

import java.lang.String;
/**
 * @author TAKeogh
 * created 29-Nov-2020 8:30:00am.
 * @version 1.0
 * Concrete class of screen that extends FunctionalDialog and allows for the addition of a RatePayer.
 */

public class AddRatePayer extends FunctionalDialog {
	
	
	
	RatePayer ratePayer = new RatePayer();
	
	public AddRatePayer(Scanner console) {
		super(1, console);
		
		System.out.print("Enter rate player's name");
		ratePayer.setName(console.nextLine());
		System.out.print("Enter rate player's postal address");
		ratePayer.setAddress(console.nextLine());
		System.out.print("Enter rate player's postcode");
		ratePayer.setPostcode(console.nextLine());
		System.out.print("Enter rate player's telephone number");
		ratePayer.setPhone(console.nextLine());
		System.out.print("Enter rate player's company type");
		ratePayer.setType(console.nextLine());
		

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


}
