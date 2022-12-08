package backend;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.util.Base64;
import java.util.Scanner;

import database.DatabaseConnection;

public class LoginController {
	
	private LoginView loginView=new LoginView();
	
	private User user;
	
	public User userLoginByEmail() throws Exception {
		
		Scanner scanner =new Scanner(System.in);
		System.out.println("Enter the email");
		String email=scanner.next();
		System.out.println("enter the password");
		String password=scanner.next();
		user=loginView.getPasswordByEmail(email);
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
	
	public User userLoginByPhone() {
		Scanner scanner =new Scanner(System.in);
		System.out.println("Enter the phone Number");
		String mobileNumber=scanner.next();
		System.out.println("enter the password");
		String password=scanner.next();
		user=loginView.getPasswordByPhoneNumber(mobileNumber);
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
