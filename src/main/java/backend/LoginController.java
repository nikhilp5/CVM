package backend;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.util.Base64;
import java.util.Scanner;

import database.DatabaseConnection;

public class LoginController {
	
	
	private User user;
	
	public User userLoginByEmail(String email,String password) throws Exception {
		user=LoginView.instance().getPasswordByEmail(email);
		String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
		if(encodedPassword.equals(user.getPassword()))
		{
			return user;
		}
		else
		{
			return null;
		}
	}
	
	public User userLoginByPhone(String mobileNumber,String password) {
		user=LoginView.instance().getPasswordByPhoneNumber(mobileNumber);
		String encodedPassword = Base64.getEncoder().encodeToString(password.getBytes());
		if(encodedPassword.equals(user.getPassword()))
		{
			return user;
		}
		else
		{
			return null;
		}
	}
}
