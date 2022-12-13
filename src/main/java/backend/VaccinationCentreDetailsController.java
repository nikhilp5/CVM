package backend;

public class VaccinationCentreDetailsController {
	
	private VaccinationCentreDetailsImpl vaccinationCentreDetailsImpl;
	
	public VaccinationCentreDetailsController(VaccinationCentreDetailsImpl vaccinationCentreDetailsImpl)
	{
		this.vaccinationCentreDetailsImpl=vaccinationCentreDetailsImpl;
	}
	
	public VaccinationCentreDetailsController() {
		super();
	}

	public String updateVaccinationCentreDetailsController(String centreCode,String updateParameterName, String value) {
		String updateResult=vaccinationCentreDetailsImpl.
				updateVaccinationCentreDetails(centreCode, updateParameterName, value);
		return updateResult;
	}
	
	public String deleteVaccinationCentreDetailsController(String centreCode) {
		String deleteResult=vaccinationCentreDetailsImpl.deleteVaccinationCentreDetails(centreCode);
		return deleteResult;
	}
	
	public boolean addVaccinationCentreDetails(VaccinationCentreDetails vaccineCentreDetails) {
		boolean insertionResult=vaccinationCentreDetailsImpl.addVaccinationCentreDetails(vaccineCentreDetails);
		return insertionResult;
	}
}
