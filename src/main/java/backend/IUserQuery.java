package backend;

import java.util.HashMap;

public interface IUserQuery {
	String insertUser(final User user);
	String getHealthWorker(String firstName,String lastName,String emailId);
	String updateHealthWorker(final User user,final HashMap<String,String> updateValues);
}
