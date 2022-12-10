package backend;

public interface IVaccinationCentreQuery {
	
	public String validCentreNumber(String centreCode);
	public String updateCentreDetails(String centreCode,String updateParameterName,String updateParameterValue);
	public String deleteCentreDetails(String centreCode);

}
