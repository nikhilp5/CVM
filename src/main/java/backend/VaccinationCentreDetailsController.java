package backend;

public class VaccinationCentreDetailsController {
	
	public static VaccinationCentreDetailsController vaccinationCentreDetailsController;
	
	  public static VaccinationCentreDetailsController instance() {
	        if (vaccinationCentreDetailsController == null) {
	        	vaccinationCentreDetailsController= new VaccinationCentreDetailsController();
	        }
	        return vaccinationCentreDetailsController;
	}
	  
	public String updateVaccinationCentreDetailsController(String centreCode,String updateParameterName, String value) {
		String updateResult=VaccinationCentreDetailsImpl.instance().
				updateVaccinationCentreDetails(centreCode, updateParameterName, value);
		return updateResult;
	}
	
	public String deleteVaccinationCentreDetailsController(String centreCode) {
		String deleteResult=VaccinationCentreDetailsImpl.instance()
				.deleteVaccinationCentreDetails(centreCode);
		return deleteResult;
	}
	
	public boolean addVaccinationCentreDetails(VaccinationCentreDetails vaccineCentreDetails) {
		boolean insertionResult=VaccinationCentreDetailsImpl.instance()
				.addVaccinationCentreDetails(vaccineCentreDetails);
		return insertionResult;
	}
}
