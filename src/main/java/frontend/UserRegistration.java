package frontend;

import java.util.Scanner;

import backend.IUserRegistrationController;
import backend.IUserRegistrationQuery;
import backend.User;
import backend.UserRegistrationController;
import backend.UserRegistrationQuery;
import database.DatabaseConnection;
import database.IDatabaseConnection;

public class UserRegistration {
	  private final IDatabaseConnection databaseConnection;
	  private final IUserRegistrationQuery userRegistrationQuery;
	  private final Scanner scanner;

	  public UserRegistration(final Scanner scanner) {
		  this.scanner = scanner;
		  databaseConnection = DatabaseConnection.instance();
		  userRegistrationQuery=UserRegistrationQuery.instance();
	  }
	  
	  public final void registerUser() {
		  try {			  
			  System.out.println("Enter first name");
			  final String firstName = scanner.nextLine().trim();
			  
			  System.out.println("Enter last name");
			  final String lastName = scanner.nextLine().trim();

			  System.out.println("Enter gender");
			  final String gender = scanner.nextLine().trim().toUpperCase();
			  
			  System.out.println("Enter mobile number");
			  final String mobileNumber = scanner.nextLine().trim();
			  
			  System.out.println("Enter email ID");
			  final String emailId = scanner.nextLine().trim();
			  
			  System.out.println("Enter Date Of Birth");
			  final String dateOfBirth = scanner.nextLine().trim();

			  System.out.println("Enter Address");
			  final String address = scanner.nextLine().trim();
			  
			  System.out.println("Enter City(Address)");
			  final String city = scanner.nextLine().trim();
			  
			  System.out.println("Enter Areacode(Address)");
			  final String areaCode = scanner.nextLine().trim();
			  
			  System.out.println("Enter password");
			  String firstPass = scanner.nextLine().trim();

			  System.out.println("Confirm password");
			  String secondPass = scanner.nextLine().trim();

			 this.confirmPassword(firstPass, secondPass);
			 
			 final String password = firstPass;
			 
			 User user=new User(firstName,lastName,gender,mobileNumber,emailId,
						dateOfBirth,address,city,areaCode,password,"USER");
			 
			 final IUserRegistrationController userRegistrationController =
				        new UserRegistrationController(
				            databaseConnection,
				            userRegistrationQuery);
			 boolean userInserted=userRegistrationController.register(user);
			 if(userInserted) {
				 System.out.println("User registered succesfully");
			 }
			 else {
				 System.out.println("User not registered");
			 }
		  }
		  catch(Exception e) {
			  e.printStackTrace();
		  }
		  finally{
			  databaseConnection.stopDatabaseConnection();
		  }
	  }
	  
	  private final void confirmPassword(String firstPass,String secondPass) {
		  while(!firstPass.equals(secondPass)) {
			  System.out.println("Enter password");
			  firstPass = scanner.nextLine().trim();

			  System.out.println("Confirm password");
			  secondPass = scanner.nextLine().trim();
		  }
	  }
}
