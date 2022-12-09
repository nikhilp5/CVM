package backend;

public class VaccinationCentreQuery implements IVaccinationCentreQuery {
	
	private static VaccinationCentreQuery vaccinationCentreQuery;
	
	  public static VaccinationCentreQuery instance() {
	        if (vaccinationCentreQuery == null) {
	        	vaccinationCentreQuery= new VaccinationCentreQuery();
	        }
	        return vaccinationCentreQuery;
	}

	@Override
	public String validCentreNumber(String centreNumber) {
		return "Select * From "+VaccinationCenterDatabaseColumns.vaccination_centre_details_table+
				" where "+VaccinationCenterDatabaseColumns.centre_code+ "='"+centreNumber+"' LIMIT 1";
	}

	@Override
	public String updateCentreDetails(String centreNumber, String updateParameterName,String updateParameterValue) {
		return "Update "+VaccinationCenterDatabaseColumns.vaccination_centre_details_table+
				" set "+updateParameterName+"='"+updateParameterValue+
				"' where "+VaccinationCenterDatabaseColumns.centre_code+ "='"+centreNumber+"' LIMIT 1";
	}

}
