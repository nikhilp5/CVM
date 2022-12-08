package frontend;

import backend.LoginController;
import backend.User;

public class Login {
	
	  private LoginController loginController=new LoginController();
	  private User user;
	  
	  
	public final User login(String option,String userParameter,String password) {
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
