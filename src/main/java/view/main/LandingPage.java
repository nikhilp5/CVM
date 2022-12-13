package view.main;

import java.util.Scanner;

import model.user.User;
import view.user.UserRegistration;

public class LandingPage {
	
    
    public static User user;
    	
	private void userRegistration(final Scanner scanner) {
		UserRegistration userRegistration =new UserRegistration(scanner);
		userRegistration.registerUser();
	}	
	public static void main(String[] args) {
		try {
		    final LandingPage cvmApp = new LandingPage();
			System.out.println("Covid Vaccination Management System \n Select an option");
			while(true) {
				Login login=new Login();
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
					user= login.login(input, scanner);
					login.Chain(user);
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
	}

}
