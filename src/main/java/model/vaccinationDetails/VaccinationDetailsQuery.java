package model.vaccinationDetails;

public final class VaccinationDetailsQuery{
	public static String fetchVaccinationDetailsQuery(String userId) {
		return "Select * from "+ VaccinationDetailsDatabaseColumns.vaccination_details_table +" where "+VaccinationDetailsDatabaseColumns.user_id+ "='"+userId+"' LIMIT 1";
	}
}
