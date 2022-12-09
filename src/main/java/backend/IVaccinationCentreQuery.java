package backend;

public interface IVaccinationCentreQuery {
	
	public String validCentreNumber(String centreNumber);
	public String updateCentreDetails(String centreNumber,String updateParameterName,String updateParameterValue);

}
