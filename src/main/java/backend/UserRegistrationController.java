package backend;

public class UserRegistrationController implements IUserRegistrationController{

	UserRegistrationImpl userRegistrationImpl=UserRegistrationImpl.instance();
	
	@Override
	public boolean register(User user) {
		return userRegistrationImpl.register(user);
	}
}
