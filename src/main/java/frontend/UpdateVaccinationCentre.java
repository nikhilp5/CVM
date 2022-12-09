package frontend;

import java.util.Scanner;

import backend.VaccinationCenterDatabaseColumns;
import backend.VaccinationCentreDetailsController;

public class UpdateVaccinationCentre {
	
	
	public void display(Scanner scanner) {
		try {
			System.out.println("enter the centre number that you want to update");
			String updateResult="";
			String centre_number=scanner.nextLine();

			System.out.println("1. Centre code\n"
					+ "2. Centre name\n"
					+ "3. Centre address\n"
					+ "4. Centre city\n"
					+ "5. Centre zip");

			System.out.println("select an option");
			String input = scanner.nextLine();
			switch(input) {
			case "1": updateResult=VaccinationCentreDetailsController.instance().vaccinationCentreDetailsController(centre_number,VaccinationCenterDatabaseColumns.centre_code,scanner);
			System.out.println(updateResult);
			break;
			case "2": updateResult=VaccinationCentreDetailsController.instance().vaccinationCentreDetailsController(centre_number,VaccinationCenterDatabaseColumns.centre_name,scanner);
			System.out.println(updateResult);
			break;
			case "3": updateResult=VaccinationCentreDetailsController.instance().vaccinationCentreDetailsController(centre_number,VaccinationCenterDatabaseColumns.centre_address,scanner);
			System.out.println(updateResult);
			break;
			case "4": updateResult=VaccinationCentreDetailsController.instance().vaccinationCentreDetailsController(centre_number,VaccinationCenterDatabaseColumns.centre_city,scanner);
			System.out.println(updateResult);
			break;
			case "5": updateResult=VaccinationCentreDetailsController.instance().vaccinationCentreDetailsController(centre_number,VaccinationCenterDatabaseColumns.centre_zip,scanner);
			System.out.println(updateResult);
			break;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
