package frontend;

import java.util.Scanner;

import backend.RoleCheck;
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
		    final LandingPage cvmApp = new LandingPage();
			System.out.println("Covid Vaccination Management System \n Select an option");
			while(true) {
				Scanner scanner = new Scanner(System.in);
				System.out.println("1. User Registration\n"
						+ "2. Login By Email\n"
						+ "3. Login By MobileNumber\n"
						+ "4. Exit");
				final String input = scanner.nextLine();
				switch(input) {
				case "1":
					cvmApp.userRegistration(scanner);
					break;
				case "2": 
				case "3":
					user= Login.instance().login(input, scanner);
					RoleCheck roleCheck=new RoleCheck();
					roleCheck.roleCheck(user);
					break;
				case "4":
					System.exit(0);
					break;
				default: 
					System.out.println("enter the correct option");
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
