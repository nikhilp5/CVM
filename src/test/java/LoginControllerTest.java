import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import backend.LoginController;
import backend.User;

public class LoginControllerTest {
	
	LoginController loginController=new LoginController();
	User user=new User();
	
	@Test
	public void userLoginByEmailTestSuccess() {
		try {
			user = loginController.userLoginByEmail("nikhil@gmail.com", "@Hello123");
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(user.getGender(),"MALE");
}
	@Test
	public void userLoginByEmailTestFailure() {
		try {
			user = loginController.userLoginByEmail("nikhil@gmail.com", "@Hello");
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(user,null);
}
	@Test
	public void userLoginByPhoneTestSuccess() {
		try {
			user = loginController.userLoginByPhone("123456789", "@Hello123");
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(user.getFirstName(),"nikhil");
	}
	@Test
	public void userLoginByPhoneTestFailure() {
		try {
			user = loginController.userLoginByPhone("312343232", "@Hello1");
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(user,null);
	}
	
	@Test
	public void userCheckTestSuccess() {
		try {
			user = loginController.userLoginByEmail("nikhil@gmail.com", "@Hello123");
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(user.getFirstName(),"nikhil");
	}
	
	@Test
	public void userCheckTestFailure() {
		try {
			user = loginController.userLoginByEmail("test@gmail.com", "@Hello");
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(user,null);
	}
}
