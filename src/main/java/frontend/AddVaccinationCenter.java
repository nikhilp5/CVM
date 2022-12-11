package frontend;

import java.util.Scanner;

import backend.VaccinationCentreDetails;
import backend.VaccinationCentreDetailsController;
import database.DatabaseConnection;
import database.IDatabaseConnection;

public class AddVaccinationCenter {
	private final IDatabaseConnection databaseConnection;
	private final Scanner scanner;

	public AddVaccinationCenter(final Scanner scanner) {
		this.scanner = scanner;
		databaseConnection = DatabaseConnection.instance();
	}
	
	public final void add() {
		try {
			System.out.println("Enter Centre Code ");
			final String centreCode = scanner.nextLine().trim().toUpperCase();
			System.out.println("Enter Centre Name ");
			final String centreName = scanner.nextLine().trim();
			System.out.println("Enter Centre Address ");
			final String centreAddress = scanner.nextLine().trim();
			System.out.println("Enter Centre City ");
			final String centreCity = scanner.nextLine().trim();
			System.out.println("Enter Centre Area Code ");
			final String centreAreaCode = scanner.nextLine().trim();

			VaccinationCentreDetails vaccinationCentreDetails=new VaccinationCentreDetails(centreCode,centreName,
					centreAddress, centreCity,centreAreaCode);

			boolean centreInserted=VaccinationCentreDetailsController.instance().addVaccinationCentreDetails(vaccinationCentreDetails);
			if(centreInserted) {
				System.out.println("Vaccine Centre registered succesfully");
			}
			else {
				System.out.println("Vaccine Centre not registered");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally{
			databaseConnection.stopDatabaseConnection();
		}
	}
}
