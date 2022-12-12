package backend;

import java.util.Base64;
import frontend.AdminPage;
import frontend.HealthWorkerPage;
import frontend.ShowDetails;

public class LoginController implements ILoginController {
	
	
	private User user;
	
	
	public User userLoginByEmail(String email,String password){
		user=LoginImpl.instance().getPasswordByEmail(email);
		user=userCheck(user,password);
		return user;
	}
	
	public User userLoginByPhone(String mobileNumber,String password) {
		user=LoginImpl.instance().getPasswordByPhoneNumber(mobileNumber);
		user=userCheck(user,password);
		return user;
	}
	public User userCheck(User user,String password) {
		if(user==null)
		{
			return user;
		}else
		{
			String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
			if(encodedPassword.equals(user.getPassword()))
			{
				return user;
			}
			else
			{
				System.out.println("wrong password");
				return null;
			}
			
		}		
	}

}