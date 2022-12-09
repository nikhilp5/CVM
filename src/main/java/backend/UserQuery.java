package backend;

import java.util.HashMap;

public class UserQuery implements IUserQuery{
	
	 private static UserQuery instance;

	 public static UserQuery instance() {
		 if (instance == null) {
			 instance = new UserQuery();
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
				UserDatabaseColumns.user_password + ", " +
				UserDatabaseColumns.user_role + ")" +
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
		        "'" + user.getPassword() + "', " +
		        "'" + user.getRole()+ "');";
	}

	@Override
	public String getHealthWorker(String firstName,String lastName,String emailId) {
		return "select * from "+UserDatabaseColumns.user_table+" where LOWER("+UserDatabaseColumns.user_first_name+")"
				+" = '"+firstName
				+"' and LOWER(" +UserDatabaseColumns.user_last_name+")"
				+" = '"+lastName
				+"' and LOWER(" +UserDatabaseColumns.user_email+")"
				+" = '"+emailId +"' and role='HEALTH_WORKER' limit 1";
	}

	@Override
	public String updateHealthWorker(User user,HashMap<String,String> updateValues) {
		String query="update "+UserDatabaseColumns.user_table+" set ";
		int count = 1;
		for (String key : updateValues.keySet()) {
		    query=query+key+"= '"+updateValues.get(key)+"'";
		    if(count==updateValues.size()) {
		    	break;
		    }
		    else {
		    	count++;
		    	query=query.concat(" , ");
		    }
		}
		query=query.concat(" where user_id= "+user.getUserId());
		return query;
	}

}