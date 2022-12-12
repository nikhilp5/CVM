import java.util.HashMap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import backend.HealthWorkerUpdateController;
import backend.IUserQuery;
import backend.User;
import backend.UserDatabaseColumns;
import backend.UserQuery;
import database.DatabaseConnection;
import database.IDatabaseConnection;

public class HealthWorkerUpdateControllerTest {
	public final IDatabaseConnection databaseConnection=DatabaseConnection.instance();
	public final IUserQuery  healthWorkerQuery=UserQuery.instance();

	HealthWorkerUpdateController healthWorkerUpdateController = new HealthWorkerUpdateController();
	
	@Test
	public void getHealthWorkerTest() {
		User healthWorker=healthWorkerUpdateController.getHealthWorker("healthWorkerFirstNameTest","healthWorkerLastNameTest","test@gmail.com");
		Assertions.assertNotNull(healthWorker);
		healthWorker=healthWorkerUpdateController.getHealthWorker("HealthWorkerNotPresent","HealthWorkerNotPresent","HealthWorkerNotPresent");
		Assertions.assertNull(healthWorker);
	}
	
	@Test
	public void checkHealthWorkerExistsTest() {
		User healthWorker=healthWorkerUpdateController.checkHealthWorkerExists("healthWorkerFirstNameTest","healthWorkerLastNameTest","test@gmail.com");
		Assertions.assertNotNull(healthWorker);
		healthWorker=healthWorkerUpdateController.checkHealthWorkerExists("HealthWorkerNotPresent","HealthWorkerNotPresent","HealthWorkerNotPresent");
		Assertions.assertNull(healthWorker);
	}
	
	@Test
	public void updateHealthWorkerDetailsTest() {
		User healthWorker=healthWorkerUpdateController.getHealthWorker("healthWorkerFirstNameTest".toLowerCase(),"healthWorkerLastNameTest".toLowerCase(),"test@gmail.com");
		HashMap<String,String> updateValues=new HashMap<String,String>();
		updateValues.put(UserDatabaseColumns.user_first_name,"***");
		Assertions.assertFalse(healthWorkerUpdateController.updateHealthWorkerDetails(healthWorker,updateValues));
		updateValues.put(UserDatabaseColumns.user_first_name,"healthWorkerFirstNameTest");
		Assertions.assertTrue(healthWorkerUpdateController.updateHealthWorkerDetails(healthWorker,updateValues));
	}
}
