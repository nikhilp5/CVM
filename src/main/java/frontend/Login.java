package frontend;

import java.util.Scanner;

import backend.LoginController;
import backend.User;
import database.DatabaseConnection;

public class Login {
	
	  private User user;
	  
	  private static Login login;

	  public static Login instance() {
	        if (login == null) {
	        	login = new Login();
	        }
	        return login;
	}
	  public final User login(String option,Scanner scanner) throws Exception {
		  LoginController loginController=new LoginController();

		  if(option.equals("2"))
		  {
			  try {
					System.out.println("Enter the email");
					String email=scanner.next();
					System.out.println("enter the password");
					String password=scanner.next();
				    user= loginController.userLoginByEmail(email,password);
			  } catch (Exception e) {
				  // TODO Auto-generated catch block
				  e.printStackTrace();
			  }
		  }
		  else
		  {
				System.out.println("Enter the mobileNumber");
				String mobileNumber=scanner.next();
				System.out.println("enter the password");
				String password=scanner.next();
			  user= loginController.userLoginByPhone(mobileNumber,password);
		  }
		  return user;	
	  }
	  
}
