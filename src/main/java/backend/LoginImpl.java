package backend;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import database.DatabaseConnection;
import java.sql.Statement;

public class LoginImpl {
	
	private User user;
	
	private static LoginImpl instance;

	 public static LoginImpl instance() {
		 if (instance == null) {
			 instance = new LoginImpl();
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
		finally {
			DatabaseConnection.instance().stopDatabaseConnection();
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
		finally {
			DatabaseConnection.instance().stopDatabaseConnection();
		}
		System.out.println(user.getRole());
		return user;
	}
	
	public User resultUser(ResultSet rs) throws SQLException
	{
		User user=new User();
		user.setUserId(rs.getString(UserDatabaseColumns.user_id));
		user.setFirstName(rs.getString(UserDatabaseColumns.user_first_name));
		user.setLastName(rs.getString(UserDatabaseColumns.user_last_name));
		user.setGender(rs.getString(UserDatabaseColumns.user_gender));
		user.setEmailId(rs.getString(UserDatabaseColumns.user_email));
		user.setMobileNumber(rs.getString(UserDatabaseColumns.user_mobile));
		user.setDateOfBirth(rs.getString(UserDatabaseColumns.user_dob));
		user.setAddress(rs.getString(UserDatabaseColumns.user_address));
		user.setAddressCity(rs.getString(UserDatabaseColumns.user_city));
		user.setAddressZipCode(rs.getString(UserDatabaseColumns.user_zip));
		user.setPassword(rs.getString(UserDatabaseColumns.user_password));
		user.setRole(rs.getString(UserDatabaseColumns.user_role));
		return user;
	}

}
