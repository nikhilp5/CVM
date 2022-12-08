package frontend;

import java.util.Scanner;

import backend.LoginController;
import backend.User;

public class LandingPage {
	
    
    public static User user;
    	
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
				System.out.println("1. User Registration\n"
						+ "2. Login By Email\n"
						+ "3. Login By MobileNumber");
				final String input = scanner.nextLine();
				switch(input) {
				case "1":
					cvmApp.userRegistration(scanner);
					break;
				case "2": 
				case "3":
					user= Login.instance().login(input, scanner);
					break;
				default: System.out.println("enter the correct option");
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
