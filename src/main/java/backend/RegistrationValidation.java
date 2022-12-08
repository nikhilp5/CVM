package backend;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public final class RegistrationValidation {

  public static boolean nameValidation(final String name) {
    if(isEmptyString(name)) {
        return false;
    }
    else {
        return Pattern.matches("[A-Za-z ]+", name);
    }
  }
  

  public static boolean genderValidation(final String gender) {
	  if(isEmptyString(gender)) {
	        return false;
	    }
	  else {
		  return Gender.isGenderValid(gender);
	  }
  }

 
  public static boolean dateValidation(final String date) {
	  if(isEmptyString(date)) {
		  return false;
	  }
	  try {
		  final String[] dateArr = date.split("-");
		  if (Integer.parseInt(dateArr[0])<=31 && dateArr[0].length() != 2) {
			  return false;
		  }
		  if (Integer.parseInt(dateArr[0])<=12 && dateArr[1].length() != 2) {
			  return false;
		  }
		  if (dateArr[2].length() != 4) {
			  return false;
		  }
		  SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY");
		  dateFormat.setLenient(false);
		  return dateFormat.parse(date) != null;
	  } catch (Exception e) {
		  return false;
	  }
  }

  public static boolean emailValidation(final String email) {
    if (email == null) {
      return false;
    }
    return Pattern.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$",
        email);//https://regexr.com/3e48o
  }


  public static boolean passwordValidation(final String password) {
	  if(isEmptyString(password)) {
		  return false;
	  }
	  else {
		    return Pattern.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$",
		            password);//https://www.geeksforgeeks.org/how-to-validate-a-password-using-regular-expressions-in-java/
	  }
  }


  public static boolean mobileNumberValidation(final String contactNumber) {
	  if(isEmptyString(contactNumber)) {
		  return false;
	  }
	  else {
		    return Pattern.matches("^(\\+\\d{1,3}( )?)?((\\(\\d{1,3}\\))|\\d{1,3})[- .]?\\d{3,4}[- .]?\\d{4}$", contactNumber);
		    //https://www.geeksforgeeks.org/java-program-to-check-for-a-valid-mobile-number/#:~:text=Mobile%20number%20validation%20in%20Java,with%20compiled%20pattern%2Fregular%20expression.
	  }
  }
  
  public static boolean areaCodeValidation(final String zipCode) {
	  if(isEmptyString(zipCode)) {
		  return false;
	  }
    return Pattern.matches("^[A-Za-z\\d]{6}$", zipCode);
  }

  
  public static boolean isEmptyString(final String text) {
		if(text==null || text.trim().isEmpty()) {
			return true;
		}
		return false;
	}
}