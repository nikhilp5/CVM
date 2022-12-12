package backend;

import frontend.AdminPage;
import frontend.HealthWorkerPage;
import frontend.ShowDetails;

public class RoleCheck {
	
	public void roleCheck(User user) {
		switch(user.getRole())
		{
		case UserType.admin:
			AdminPage admin=new AdminPage();
			admin.display();
		case UserType.user:
			ShowDetails sh1 = new ShowDetails();
			sh1.showUserDetails(user);
			sh1.showVaccinationDetails(user);
			sh1.showVaccinationCentre(user);
		case UserType.healthworker:
			HealthWorkerPage healthWorkerPage = new HealthWorkerPage();
			healthWorkerPage.display();
			
	}
}
}
