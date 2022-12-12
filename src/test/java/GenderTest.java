import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import backend.Gender;

public class GenderTest {
	
	@Test
	public void isGenderValidTest() {
		Gender genderTest=new Gender();
		Assertions.assertTrue(genderTest.isGenderValid("MALE"));
		Assertions.assertTrue(genderTest.isGenderValid("FEMALE"));
		Assertions.assertTrue(genderTest.isGenderValid("OTHER"));
		Assertions.assertFalse(genderTest.isGenderValid("NegativeTest"));
	}
	
}
