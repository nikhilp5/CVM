package frontend;
import java.util.Scanner;

public class AdminPage {
	
	private void updateHealthWorker(final Scanner scanner) {
		final UpdateHealthWorker updateHealthWorker =new UpdateHealthWorker(scanner);
		updateHealthWorker.update();
	}
	
	private void addVaccinationCenter(final Scanner scanner) {
	}
	
	private void updateVaccinationCenter(final Scanner scanner) {
	}
	
	private void deleteVaccinationCenter(final Scanner scanner) {
	}
	
	private void display() {
		final Scanner scanner = new Scanner(System.in);
	    final AdminPage adminPage = new AdminPage();
		System.out.println("Welcome Admin \nSelect an option");
		System.out.println("1. Update Health Worker\n"
				+ "2. Add Vaccination center\n"
				+ "3. Update Vaccination center\n"
				+ "4. Delete Vaccination center\n ");
		final String input = scanner.nextLine();
		while(true) {
			switch(input) {
			case "1":
				adminPage.updateHealthWorker(scanner);
				break;
			case "2": 
				adminPage.addVaccinationCenter(scanner);
				break;
			case "3":
				adminPage.updateVaccinationCenter(scanner);
				break;
			case "4":
				adminPage.deleteVaccinationCenter(scanner);
				break;
			default: System.out.println("enter the correct option");
				break;
			}
		}
	}
}
