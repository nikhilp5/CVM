import java.util.HashMap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import backend.UserUpdateController;
import backend.IUserQuery;
import backend.User;
import backend.UserDatabaseColumns;
import backend.UserQuery;
import database.DatabaseConnection;
import database.IDatabaseConnection;

public class UserUpdateControllerTest
{
    public final IDatabaseConnection databaseConnection = DatabaseConnection.instance();
    public final IUserQuery userQuery = UserQuery.instance();

    UserUpdateController userUpdateController = new UserUpdateController();

    @Test
    public void getUserTest()
    {
        User user = userUpdateController.getUser("UserNotPresent","UserNotPresent","UserNotPresent");
        Assertions.assertNull(user);
    }

    @Test
    public void checkUserExistsTest()
    {
        User user = userUpdateController.checkUserExists("UserNotPresent","UserNotPresent","UserNotPresent");
        Assertions.assertNull(user);
    }

    @Test
    public void updateUserDetailsTest()
    {
        User user = userUpdateController.getUser("userFirstNameTest".toLowerCase(),"userLastNameTest".toLowerCase(),"test@gmail.com");
        HashMap<String,String> updateValues=new HashMap<String,String>();
        updateValues.put(UserDatabaseColumns.user_first_name,"***");
        Assertions.assertFalse(userUpdateController.updateUserDetails(user,updateValues));
    }
}
