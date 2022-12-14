package model.vaccinationDetails;

import database.DatabaseConnection;
import model.user.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class VaccinationDetailsImpl {

	VaccinationDetails vac_details = new VaccinationDetails();

	public VaccinationDetails selectVaccinationDetails(User user) {
		try {
			Connection connection = DatabaseConnection.instance().getDatabaseConnection();
			Statement statement = connection.createStatement();
			String selectQuery = VaccinationDetailsQuery.fetchVaccinationDetailsQuery(user.getUserId());
			ResultSet rs = statement.executeQuery(selectQuery);
			if(rs.next()) {
				vac_details = resultVaccinationDetails(rs);
			}
			connection.close();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return vac_details;
	}

	public VaccinationDetails resultVaccinationDetails(ResultSet rs){
		try{
			vac_details.setUser_id(rs.getString(VaccinationDetailsDatabaseColumns.user_id));
			vac_details.setVaccination_status(rs.getString(VaccinationDetailsDatabaseColumns.vaccination_status));
			vac_details.setDose1(rs.getString(VaccinationDetailsDatabaseColumns.dose1));
			vac_details.setDose1_date(rs.getString(VaccinationDetailsDatabaseColumns.dose1_date));
			vac_details.setDose1_healthworker(rs.getString(VaccinationDetailsDatabaseColumns.dose1_healthworker));
			vac_details.setDose2(rs.getString(VaccinationDetailsDatabaseColumns.dose2));
			vac_details.setDose2_date(rs.getString(VaccinationDetailsDatabaseColumns.dose2_date));
			vac_details.setDose1_healthworker(rs.getString(VaccinationDetailsDatabaseColumns.dose2_healthworker));
		}
		catch (Exception e){
			System.out.println(e);
		}
		return vac_details;
	}
}
