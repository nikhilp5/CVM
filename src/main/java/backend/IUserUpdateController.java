package backend;

import java.util.HashMap;

public interface IUserUpdateController {

    User checkUserExists(final String firstName,final String lastName,final String emailId);
    User getUser(final String firstName,final String lastName,final String emailId);
    boolean updateUserDetails(final User user,final HashMap<String,String> updateValues);
}
