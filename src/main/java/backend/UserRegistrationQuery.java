package backend;

public class UserRegistrationQuery implements IUserRegistrationQuery{
	
	 private static UserRegistrationQuery instance;

	 public static UserRegistrationQuery instance() {
		 if (instance == null) {
			 instance = new UserRegistrationQuery();
		 }
		 return instance;
	 }

	@Override
	public String insertUser(User user) {
		return "insert into " + UserDatabaseColumns.user_table + "(" +
				UserDatabaseColumns.user_first_name + ", " +
				UserDatabaseColumns.user_last_name + ", " +
				UserDatabaseColumns.user_gender + ", " +
				UserDatabaseColumns.user_mobile + ", " +
				UserDatabaseColumns.user_email + ", " +
				UserDatabaseColumns.user_dob + ", " +
				UserDatabaseColumns.user_address + ", " +
				UserDatabaseColumns.user_city + ", " +
				UserDatabaseColumns.user_zip + ", " +
				UserDatabaseColumns.user_password + ")" +
		        "values (" +
		        "'" + user.getFirstName() + "', " +
		        "'" + user.getLastName() + "', " +
		        "'" + user.getGender() + "', " +
		        "'" + user.getMobileNumber() + "', " +
		        "'" + user.getEmailId() + "', " +
		        "'" + user.getDateOfBirth() + "', " +
		        "'" + user.getAddress() + "', " +
		        "'" + user.getAddressCity() + "', " +
		        "'" + user.getAddressZipCode() + "', " +
		        "'" + user.getPassword() + "');";
	}

}
