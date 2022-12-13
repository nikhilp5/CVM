package backend;

import java.util.HashMap;

public class HealthWorkerUpdateController implements IHealthWorkerUpdateController{
	
	UserUpdateTemplate healthWorkerUpdateImpl=HealthWorkerUpdateImpl.instance();
	
	@Override
	public User getHealthWorker(String firstName, String lastName, String emailId) {
		return healthWorkerUpdateImpl.getUser(firstName, lastName, emailId);
	}
	
	@Override
	public User checkHealthWorkerExists(String firstName,String lastName,String emailId) {
		return healthWorkerUpdateImpl.checkUserExists(firstName, lastName, emailId);
	}

	@Override
	public boolean updateHealthWorkerDetails(User user,final HashMap<String,String> updateValues) {
		return healthWorkerUpdateImpl.updateUserDetails(user, updateValues);
	}
}
