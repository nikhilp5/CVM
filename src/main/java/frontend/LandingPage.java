package frontend;

import java.util.Scanner;

public class LandingPage {
	
	private void userRegistration(final Scanner scanner) {
		final UserRegistration userRegistration =new UserRegistration(scanner);
		userRegistration.registerUser();
	}
	
	public static void main(String[] args) {
		try {
			//Connection currentConnection=DatabaseConnection.Instance().getDatabaseConnection();
			final Scanner scanner = new Scanner(System.in);
		    final LandingPage cvmApp = new LandingPage();
			System.out.println("Covid Vaccination Management System \n Select an option");
			while(true) {
				System.out.println("1.User Registration");
				final String input = scanner.nextLine();
				switch(input) {
				case "1":
					cvmApp.userRegistration(scanner);
					break;
				default:
					break;
				}
			}
		}
		catch(Exception e) {

		}
		finally{
			//DatabaseConnection.Instance().stopDatabaseConnection();
		}
	}

}
