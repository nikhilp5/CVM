package backend;

import frontend.AdminPage;
import frontend.ShowDetails;

public class UserProcessor extends LoginProcessor {

	public UserProcessor(LoginProcessor nextLoginProcessor) {
		super(nextLoginProcessor);
	}
	
	public void process(User user)
	{
		if (user.getRole().equals(UserType.user))
		{
			ShowDetails sh1 = new ShowDetails();
			sh1.showUserDetails(user);
			sh1.showVaccinationDetails(user);
			sh1.showVaccinationCentre(user);
		}
		else
		{
			super.process(user);
		}
	}

}