package backend;

import java.util.Base64;
import frontend.AdminPage;
import frontend.ShowDetails;

public class LoginController {
	
	
	private User user;
	
	
	public User userLoginByEmail(String email,String password) throws Exception {
		user=LoginImpl.instance().getPasswordByEmail(email);
		user=userCheck(user,password);
		return user;
	}
	
	public User userLoginByPhone(String mobileNumber,String password) throws Exception {
		user=LoginImpl.instance().getPasswordByPhoneNumber(mobileNumber);
		user=userCheck(user,password);
		return user;
	}
	public User userCheck(User user,String password) throws Exception {
		if(user==null)
		{
			return user;
		}else
		{
			String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
			if(encodedPassword.equals(user.getPassword()))
			{
				roleCheck(user);
				return user;
			}
			else
			{
				System.out.println("wrong password");
				return null;
			}
			
		}		
	}
	
	public void roleCheck(User user) throws Exception {
		if(user.getRole().equals("ADMIN"))
		{
			AdminPage admin=new AdminPage();
			admin.display();
		}
		if(user.getRole().equals("USER")){
			ShowDetails sh1 = new ShowDetails();
			sh1.showUserDetails(user);
			sh1.showVaccinationDetails(user);
		}
	}
}
