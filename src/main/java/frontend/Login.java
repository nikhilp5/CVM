package frontend;

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
	  public final User login(String option,String userParameter,String password) {
		  LoginController loginController=new LoginController();

		  if(option.equals("2"))
		  {
			  try {
				  user= loginController.userLoginByEmail(userParameter,password);
			  } catch (Exception e) {
				  // TODO Auto-generated catch block
				  e.printStackTrace();
			  }
		  }
		  else
		  {
			  user= loginController.userLoginByPhone(userParameter,password);
		  }
		  return user;	
	  }
	  
}
