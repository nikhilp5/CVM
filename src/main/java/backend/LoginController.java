package backend;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.util.Base64;
import java.util.Scanner;

import database.DatabaseConnection;
import frontend.Admin;

public class LoginController {
	
	
	private User user;
	
	
	public User userLoginByEmail(String email,String password) throws Exception {
		user=LoginView.instance().getPasswordByEmail(email);
		user=userCheck(user,password);
		return user;
	}
	
	public User userLoginByPhone(String mobileNumber,String password) {
		user=LoginView.instance().getPasswordByPhoneNumber(mobileNumber);
		user=userCheck(user,password);
		return user;
	}
	public User userCheck(User user,String password) {
		if(user!=null)
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
		return user;
	}
}
