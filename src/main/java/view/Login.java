package view;

import java.util.Scanner;

import controller.LoginController;
import model.LoginChain;
import model.LoginImpl;
import model.User;

public class Login {
	
	  private User user;
	  
	  public final User login(String option,Scanner scanner) throws Exception {
		  LoginImpl loginImpl=new LoginImpl();
		  LoginController loginController=new LoginController(loginImpl);

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
	  
	  public void Chain(User user) {
		  if(user==null)
		  {
			  System.out.println("wrong password");
		  }
		  else
		  {
			LoginChain loginChain=new LoginChain();
			loginChain.process(user);
		  }
	  }
	  
	  
}
