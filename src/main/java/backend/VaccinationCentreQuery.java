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
	public String validCentreNumber(String centreCode) {
		return "Select * From "+VaccinationCenterDatabaseColumns.vaccination_centre_details_table+
				" where "+VaccinationCenterDatabaseColumns.centre_code+ "='"+centreCode+"' LIMIT 1";
	}

	@Override
	public String updateCentreDetails(String centreCode, String updateParameterName,String updateParameterValue) {
		return "Update "+VaccinationCenterDatabaseColumns.vaccination_centre_details_table+
				" set "+updateParameterName+"='"+updateParameterValue+
				"' where "+VaccinationCenterDatabaseColumns.centre_code+ "='"+centreCode+"' LIMIT 1";
	}

	@Override
	public String deleteCentreDetails(String centreCode) {
		return "Delete From "+VaccinationCenterDatabaseColumns.vaccination_centre_details_table+
				" where "+VaccinationCenterDatabaseColumns.centre_code+ "="+centreCode;
	}

}
