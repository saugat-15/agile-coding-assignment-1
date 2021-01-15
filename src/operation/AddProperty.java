package operation;

import java.util.Scanner;

import domain.Commercial;
import domain.Community;
import domain.Hospital;
import domain.Residential;
import domain.School;
import domain.VacantLand;
import domain.Industrial;
import domain.OtherProperty;

/**
 * @author TAKeogh
 * created 29-Nov-2020 8:30:00am.
 * @version 1.0
 * Concrete class of screen that extends FunctionalDialog and allows for the addition of a Property for a RatePayer.
 */

public class AddProperty extends FunctionalDialog {

	public AddProperty(Scanner console) {
		
		super(1,console);
		int choice;
		System.out.println("Enter the type of property: ");
		System.out.println("1. Resedential");
		System.out.println("2. Commercial");
		System.out.println("3. Vacant land");
		System.out.println("4. Hospital");
		System.out.println("5. Industrial");
		System.out.println("6. School");
		choice = Integer.parseInt(console.nextLine());
		
		switch(choice) {
		case 1:
			Residential residential = new Residential();
			System.out.println("Enter the property type:");
			residential.setPropertyType(console.nextLine());
			System.out.println("Enter the architecture style:");
			residential.setArchitecturalStyle(console.nextLine());
		case 2:
			Commercial commercial = new Commercial();
			System.out.println("Enter the business name");
			commercial.setBusinessName(console.nextLine());
			System.out.println("Enter the abn:");
			commercial.setAbn(console.nextLine());
		case 3:
			VacantLand vac = new VacantLand();
			System.out.println("Enter the overlays:");
			vac.setOverlays(console.nextLine());
		case 4:
			Hospital hospital = new Hospital();
			System.out.println("Enter the status (public or private): ");
			hospital.setStatus(console.nextLine());
			System.out.println("Enter the hospital facilities");
			hospital.setFacilities(console.nextLine());
			System.out.println("Enter the number of floors");
			hospital.setFloors(console.nextLine());
		case 5:
			Industrial industrial = new Industrial();
			System.out.println("Enter the hazard status:");
			industrial.setHazardStatus(console.nextLine());
			System.out.println("Enter the heavy vehicle status:");
			industrial.setHeavyVehicleStatus(console.nextLine());
		case 6:
			School school = new School();
			System.out.println("Enter the classification:");
			school.setClassification(console.nextLine());
		case 7:
			Community community = new Community();
			System.out.println("Enter the category");
			community.setCategory(console.nextLine());
		case 8:
			OtherProperty other = new OtherProperty();
			System.out.println("Enter other property type:");
			other.setSpecialDescription(console.nextLine());
			
			
		default:
		}
		
		
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
