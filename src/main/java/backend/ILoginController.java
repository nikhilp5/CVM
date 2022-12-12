package backend;

public interface ILoginController {
	public User userLoginByEmail(String email,String password);
	public User userLoginByPhone(String mobileNumber,String password);
	public User userCheck(User user,String password);
}
