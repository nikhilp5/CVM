package backend;

import java.util.HashMap;

public class HealthWorkerUpdateController implements IHealthWorkerUpdateController{
	
	HealthWorkerUpdateImpl healthWorkerUpdateImpl=HealthWorkerUpdateImpl.instance();
	
	@Override
	public User getHealthWorker(String firstName, String lastName, String emailId) {
		return healthWorkerUpdateImpl.getHealthWorker(firstName, lastName, emailId);
	}
	
	@Override
	public User checkHealthWorkerExists(String firstName,String lastName,String emailId) {
		return healthWorkerUpdateImpl.checkHealthWorkerExists(firstName, lastName, emailId);
	}

	@Override
	public boolean updateHealthWorkerDetails(User user,final HashMap<String,String> updateValues) {
		return healthWorkerUpdateImpl.updateHealthWorkerDetails(user, updateValues);
	}
}
