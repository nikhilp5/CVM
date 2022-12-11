import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import backend.VaccinationCenterDatabaseColumns;
import backend.VaccinationCentreDetails;
import backend.VaccinationCentreDetailsController;

public class VaccinationCentreDetailsControllerTest {
	
	
	@Test
	public void updateVaccinationCentreDetailsTestSuccess() {
		String updationResult=VaccinationCentreDetailsController.instance()
				.updateVaccinationCentreDetailsController("2002",VaccinationCenterDatabaseColumns.centre_name,"iwk hospital");
		assertEquals(updationResult, "update successful");
	}
	
	@Test
	public void updateVaccinationCentreDetailsTestFailure() {
		String updationResult=VaccinationCentreDetailsController.instance()
				.updateVaccinationCentreDetailsController("11002",VaccinationCenterDatabaseColumns.centre_name,"iwk hospital");
		assertEquals(updationResult, "wrong centre code");
	}
	
	@Test
	public void deleteVaccinationCentreDetailsTestSuccess() {
		VaccinationCentreDetailsController.instance()
		.addVaccinationCentreDetails(vaccinationCentreDetailsTestObject());
		String deletionResult=VaccinationCentreDetailsController.instance()
				.deleteVaccinationCentreDetailsController("2006");
		assertEquals(deletionResult, "deleted successfully");
	}
	
	@Test
	public void deleteVaccinationCentreDetailsTestFailure() {
		String deletionResult=VaccinationCentreDetailsController.instance()
				.deleteVaccinationCentreDetailsController("2010");
		assertEquals(deletionResult, "wrong centre code");
	}
	
	@Test
	public void addVaccinationCentreDetailsTestSuccess() {
		boolean insertionResult=VaccinationCentreDetailsController.instance()
				.addVaccinationCentreDetails(vaccinationCentreDetailsTestObject());
		assertEquals(insertionResult,true);
		VaccinationCentreDetailsController.instance()
		.deleteVaccinationCentreDetailsController("2006");
	}
	
	@Test
	public void addVaccinationCentreDetailsTestFailure() {
		boolean insertionResult=VaccinationCentreDetailsController.instance()
				.addVaccinationCentreDetails(vaccinationCentreDetailsTestObject2());
		assertEquals(insertionResult,false);
	}
	
	
	public VaccinationCentreDetails vaccinationCentreDetailsTestObject() {
		VaccinationCentreDetails vaccinationCentreDetailsTestObject=new VaccinationCentreDetails();
		vaccinationCentreDetailsTestObject.setCentre_name("northwood");
		vaccinationCentreDetailsTestObject.setCentre_city("halifax");
		vaccinationCentreDetailsTestObject.setCentre_address("gottingen street");
		vaccinationCentreDetailsTestObject.setCentre_zip("B30H72");
		vaccinationCentreDetailsTestObject.setCentre_code("2006");
		return vaccinationCentreDetailsTestObject;
	}
	
	public VaccinationCentreDetails vaccinationCentreDetailsTestObject2() {
		VaccinationCentreDetails vaccinationCentreDetailsTestObject=new VaccinationCentreDetails();
		vaccinationCentreDetailsTestObject.setCentre_name("");
		vaccinationCentreDetailsTestObject.setCentre_city("halifax");
		vaccinationCentreDetailsTestObject.setCentre_address("gottingen street");
		vaccinationCentreDetailsTestObject.setCentre_zip("B30H72");
		vaccinationCentreDetailsTestObject.setCentre_code("2006");
		return vaccinationCentreDetailsTestObject;
	}

}
