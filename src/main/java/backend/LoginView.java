package backend;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.DatabaseConnection;
import java.sql.Statement;

public class LoginView {
	
	private User user;
	
	private static LoginView instance;

	 public static LoginView instance() {
		 if (instance == null) {
			 instance = new LoginView();
		 }
		 return instance;
	 }
	
	public User getPasswordByEmail(String email)
	{
		try {
			Connection connection=DatabaseConnection.instance().getDatabaseConnection();
			Statement statement= connection.createStatement();
			String getQuery = LoginQuery.instance().loginByEmail(email);
			ResultSet rs = statement.executeQuery(getQuery);
			
			if(rs.next()) {
				user=resultUser(rs);
				}
			connection.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	public User getPasswordByPhoneNumber(String phoneNumber)
	{
		try {
			Connection connection=DatabaseConnection.instance().getDatabaseConnection();
			Statement statement= connection.createStatement();
			String getQuery = LoginQuery.instance().loginByMobile(phoneNumber);
			ResultSet rs = statement.executeQuery(getQuery);
			if(rs.next()){
				  user=resultUser(rs);
				}
			connection.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(user.getRole());
		return user;
	}
	
	public User resultUser(ResultSet rs) throws SQLException
	{
		User user=new User();
		user.setUserId(rs.getString("user_id"));
		user.setFirstName(rs.getString("firstname"));
		user.setLastName(rs.getString("lastName"));
		user.setGender(rs.getString("gender"));
		user.setEmailId(rs.getString("email"));
		user.setMobileNumber(rs.getString("mobile"));
		user.setDateOfBirth(rs.getString("dob"));
		user.setAddress(rs.getString("address"));
		user.setAddressCity(rs.getString("city"));
		user.setAddressZipCode(rs.getString("zip"));
		user.setPassword(rs.getString("password"));
		user.setRole(rs.getString("role"));
		return user;
	}

}
