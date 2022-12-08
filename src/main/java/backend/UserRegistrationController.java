package backend;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;

import database.IDatabaseConnection;

public class UserRegistrationController implements IUserRegistrationController{

	private final IDatabaseConnection databaseConnection;

	private final IUserRegistrationQuery  userRegistrationQuery;


	public UserRegistrationController(final IDatabaseConnection
			databaseConnection,
			final IUserRegistrationQuery
			userRegistrationQuery) {
		this.databaseConnection =databaseConnection;
		this.userRegistrationQuery =userRegistrationQuery;
}
	@Override
	public boolean register(User user) {
		try {
			ArrayList<String> errorList=validateUserInputs(user);
			if(errorList.size()!=0) {
				for(String error:errorList) {
					System.out.println(error);
				}
				return false;
			}
			String encodedPassword = Base64.getEncoder().encodeToString(user.getPassword().getBytes());
			user.setPassword(encodedPassword);
			Statement statement = databaseConnection.getDatabaseConnection().createStatement();
		    String insertUserQuery = userRegistrationQuery.insertUser(user);
		    int rowCount=statement.executeUpdate(insertUserQuery);
		    if (rowCount > 0) {
		    	return true;
		    }
			return false;
		}
		catch(Exception e) {
			databaseConnection.stopDatabaseConnection();
			e.printStackTrace();
			return false;
		}
	}

	private ArrayList<String> validateUserInputs(User user){
		ArrayList<String> errorList=new ArrayList<String>();

		if(!RegistrationValidation.nameValidation(user.getFirstName())) {
			errorList.add("First Name is not Valid"); }
		if(!RegistrationValidation.nameValidation(user.getLastName())) {
			errorList.add("Last Name is not Valid"); }
		if(!RegistrationValidation.mobileNumberValidation(user.getMobileNumber())) {
			errorList.add("Mobile Number is not Valid"); }
		if(!RegistrationValidation.genderValidation(user.getGender())) {
			errorList.add("Gender is not Valid"); }
		if(!RegistrationValidation.emailValidation(user.getEmailId())) {
			errorList.add("Email ID is not Valid"); }
		if(!RegistrationValidation.dateValidation(user.getDateOfBirth())) {
			errorList.add("Date of Birth is not Valid"); }
		if(!RegistrationValidation.areaCodeValidation(user.getAddressZipCode())) {
			errorList.add("Area Code/Zip Code is not Valid"); }
		if(!RegistrationValidation.passwordValidation(user.getPassword())) {
			errorList.add("Password is not Valid"); }
		return errorList;
	}
}
