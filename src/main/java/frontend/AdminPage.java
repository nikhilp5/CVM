package frontend;
import java.util.Scanner;

public class AdminPage {
	
	private void updateHealthWorker(final Scanner scanner) {
		final UpdateHealthWorker updateHealthWorker =new UpdateHealthWorker(scanner);
		updateHealthWorker.update();
	}
	
	private void addVaccinationCenter(final Scanner scanner) {
	}
	
	private void updateVaccinationCenter(final Scanner scanner){
		
		UpdateVaccinationCentre updateVaccinationCentre=new UpdateVaccinationCentre();
		try {
			updateVaccinationCentre.display(scanner);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void deleteVaccinationCenter(final Scanner scanner) {
	}
	
	public void display(){
		final Scanner scanner = new Scanner(System.in);
	    final AdminPage adminPage = new AdminPage();
    	System.out.println("Welcome Admin \nSelect an option");
    	boolean logout=true;
	    while(logout) {
			System.out.println("1. Update Health Worker\n"
					+ "2. Add Vaccination center\n"
					+ "3. Update Vaccination center\n"
					+ "4. Delete Vaccination center\n"
					+ "5. Logout\n");
			final String input = scanner.nextLine();
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
				case "5":
					logout=false;
					break;
				default: System.out.println("enter the correct option");
					break;
				}
	    }
		
	}
}
