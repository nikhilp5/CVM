import java.sql.Statement;
import java.util.Base64;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import backend.IUserQuery;
import backend.IUserRegistrationController;
import backend.User;
import backend.UserDatabaseColumns;
import backend.UserQuery;
import backend.UserRegistrationController;
import database.DatabaseConnection;
import database.IDatabaseConnection;

public class UserRegistrationControllerTest {
	public final IDatabaseConnection databaseConnection=DatabaseConnection.instance();
	public final IUserQuery  userQuery=UserQuery.instance();
	final IUserRegistrationController userRegistrationController = new UserRegistrationController();
	
	@Test
	public void registerTest() {
		try {
			User user=new User("firstNameTest","lastNameTest","MALE","123456789","test@gmail.com",
					"10-10-2020","TestAddress", "TestAddressCity", 
					"B3kC94","Hello@123","USER");
			Assertions.assertTrue(userRegistrationController.register(user));
			String queryForDeletionAfterTest="delete from "+ UserDatabaseColumns.user_table
					+" where "+ UserDatabaseColumns.user_first_name
					+" = 'firstNameTest' and "+ UserDatabaseColumns.user_last_name
					+" = 'lastNameTest'";
			Statement statement = databaseConnection.getDatabaseConnection().createStatement();
			statement.executeUpdate(queryForDeletionAfterTest);
			user.setPassword(new String(Base64.getDecoder().decode(user.getPassword())));
			user.setFirstName("***");
			Assertions.assertFalse(userRegistrationController.register(user));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally{
			databaseConnection.stopDatabaseConnection();
		}
	}

}
