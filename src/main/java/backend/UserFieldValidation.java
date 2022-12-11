package backend;

import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

public final class UserFieldValidation {

  public static boolean nameValidation(final String name) {
    if(isEmptyString(name)) {
        return true;
    }
    else {
        return !Pattern.matches("[A-Za-z ]+", name);
    }
  }
  

  public static boolean genderValidation(final String gender) {
	  if(isEmptyString(gender)) {
	        return true;
	    }
	  else {
		  return !Gender.isGenderValid(gender);
	  }
  }

 
  public static boolean dateValidation(final String date) {
	  if(isEmptyString(date)) {
		  return true;
	  }
	  try {
		  final String[] dateArr = date.split("-");
		  if (Integer.parseInt(dateArr[0])>0 && Integer.parseInt(dateArr[0])<=31 && dateArr[0].length() != 2) {
			  return true;
		  }
		  if (Integer.parseInt(dateArr[1])>0 && Integer.parseInt(dateArr[1])<=12 && dateArr[1].length() != 2) {
			  return true;
		  }
		  if (dateArr[2].length() != 4) {
			  return true;
		  }
		  SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY");
		  dateFormat.setLenient(false);
		  return !(dateFormat.parse(date) != null);
	  } catch (Exception e) {
		  return true;
	  }
  }

  public static boolean emailValidation(final String email) {
    if (isEmptyString(email)) {
      return true;
    }
    return !Pattern.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$",
        email);//https://regexr.com/3e48o
  }


  public static boolean passwordValidation(final String password) {
	  if(isEmptyString(password)) {
		  return true;
	  }
	  else {
		    return !Pattern.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$",
		            password);//https://www.geeksforgeeks.org/how-to-validate-a-password-using-regular-expressions-in-java/
	  }
  }


  public static boolean mobileNumberValidation(final String contactNumber) {
	  if(isEmptyString(contactNumber)) {
		  return true;
	  }
	  else {
		    return !Pattern.matches("^(\\+\\d{1,3}( )?)?((\\(\\d{1,3}\\))|\\d{1,3})[- .]?\\d{3,4}[- .]?\\d{4}$", contactNumber);
		    //https://www.geeksforgeeks.org/java-program-to-check-for-a-valid-mobile-number/#:~:text=Mobile%20number%20validation%20in%20Java,with%20compiled%20pattern%2Fregular%20expression.
	  }
  }
  
  public static boolean areaCodeValidation(final String zipCode) {
	  if(isEmptyString(zipCode)) {
		  return true;
	  }
    return !Pattern.matches("^[A-Za-z\\d]{6}$", zipCode);
  }

  
  public static boolean isEmptyString(final String text) {
		if(text==null || text.trim().isEmpty()) {
			return true;
		}
		return false;
	}
  
  public static boolean timeValidation(final String text) {
	  if(isEmptyString(text)) {
		  return true;
	  }
	  else {
		    return !Pattern.matches("([01]?[0-9]|2[0-3]):[0-5][0-9]", text);
		    //https://www.w3schools.blog/validate-24-hours-format-regular-expression-regex-java
	  }
	}
}