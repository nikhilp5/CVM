package backend;

import java.util.HashMap;

public class UserUpdateController implements IUserUpdateController {

    UserUpdateImpl userUpdateImpl = UserUpdateImpl.instance();

    @Override
    public User getUser(String firstName, String lastName, String emailId) {
        return userUpdateImpl.getUser(firstName, lastName, emailId);
    }

    @Override
    public User checkUserExists(String firstName,String lastName,String emailId) {
        return userUpdateImpl.checkUserExists(firstName, lastName, emailId);
    }

    @Override
    public boolean updateUserDetails(User user,final HashMap<String,String> updateValues) {
        return userUpdateImpl.updateUserDetails(user, updateValues);
    }
}
