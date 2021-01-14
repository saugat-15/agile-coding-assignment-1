package operation;

import java.util.Scanner;

/**
 * @author TAKeogh
 * created 29-Nov-2020 8:30:00am.
 * @version 1.0
 * Concrete class of screen that extends FunctionalDialog and allows for the addition of a RatePayer.
 */

public class AddRatePayer extends FunctionalDialog {

	public AddRatePayer(Scanner console) {
		super(1, console);
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
