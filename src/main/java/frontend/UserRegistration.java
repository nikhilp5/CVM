package frontend;

import java.util.Scanner;

import backend.IUserRegistrationController;
import backend.User;
import backend.UserRegistrationController;
import backend.UserType;

public class UserRegistration {
	  private final Scanner scanner;

	  public UserRegistration(final Scanner scanner) {
		  this.scanner = scanner;
	  }
	  
	  public final void registerUser() {
		  try {			  
			  System.out.println("Enter first name \n");
			  final String firstName = scanner.nextLine().trim();
			  
			  System.out.println("Enter last name \n");
			  final String lastName = scanner.nextLine().trim();

			  System.out.println("Enter gender (MALE/FEMALE/OTHER) \n");
			  final String gender = scanner.nextLine().trim().toUpperCase();
			  
			  System.out.println("Enter mobile number \n");
			  final String mobileNumber = scanner.nextLine().trim();
			  
			  System.out.println("Enter email ID \n");
			  final String emailId = scanner.nextLine().trim();
			  
			  System.out.println("Enter Date Of Birth(dd-mm-yyyy) \n");
			  final String dateOfBirth = scanner.nextLine().trim();

			  System.out.println("Enter Address \n");
			  final String address = scanner.nextLine().trim();
			  
			  System.out.println("Enter City(Address) \n");
			  final String city = scanner.nextLine().trim();
			  
			  System.out.println("Enter Areacode(Address) \n");
			  final String areaCode = scanner.nextLine().trim();
			  
			  System.out.println("Enter password(1 Uppercase/1 Lowercase/1 Number/1 Special Character)\n ");
			  String firstPass = scanner.nextLine().trim();

			  System.out.println("Confirm password \n");
			  String secondPass = scanner.nextLine().trim();

			 this.confirmPassword(firstPass, secondPass);
			 
			 final String password = firstPass;
			 
			 User user=new User(firstName,lastName,gender,mobileNumber,emailId,
						dateOfBirth,address,city,areaCode,password,UserType.user);
			 
			 final IUserRegistrationController userRegistrationController = new UserRegistrationController();
			 boolean userInserted=userRegistrationController.register(user);
			 if(userInserted) {
				 System.out.println("User registered succesfully \n");
			 }
			 else {
				 System.out.println("User not registered \n");
			 }
		  }
		  catch(Exception e) {
			  e.printStackTrace();
		  }
	  }
	  
	  private final void confirmPassword(String firstPass,String secondPass) {
		  while(!firstPass.equals(secondPass)) {
			  System.out.println("Enter password \n ");
			  firstPass = scanner.nextLine().trim();

			  System.out.println("Confirm password \n ");
			  secondPass = scanner.nextLine().trim();
		  }
	  }
}
