package backend;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import database.DatabaseConnection;

public class VaccinationCentreDetailsController {
	
	public static VaccinationCentreDetailsController vaccinationCentreDetailsController;
	
	  public static VaccinationCentreDetailsController instance() {
	        if (vaccinationCentreDetailsController == null) {
	        	vaccinationCentreDetailsController= new VaccinationCentreDetailsController();
	        }
	        return vaccinationCentreDetailsController;
	}
	  
	public String updateVaccinationCentreDetailsController(String centreCode,String updateParameterName, Scanner scanner) {
		try {
			Connection connection=DatabaseConnection.instance().getDatabaseConnection();
			Statement statement= connection.createStatement();
			String selectResult=VaccinationCentreQuery.instance().validCentreNumber(centreCode);
			ResultSet rs=statement.executeQuery(selectResult);
			if(rs.next())
			{
				System.out.println("enter the "+updateParameterName+" value");
				String value=scanner.nextLine();
				Statement updateStatement= connection.createStatement();
				String updateResult= VaccinationCentreQuery.instance().updateCentreDetails(centreCode, updateParameterName,value);
				int resultSet=updateStatement.executeUpdate(updateResult);
				return "update successful";
			}
			else
			{
				return "wrong centre code";
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			return "wrong centre code";
		}
	}
	
	public String deleteVaccinationCentreDetailsController(String centreCode) {
		try
		{
		Connection connection=DatabaseConnection.instance().getDatabaseConnection();
		Statement statement= connection.createStatement();
		String selectResult=VaccinationCentreQuery.instance().validCentreNumber(centreCode);
		ResultSet rs=statement.executeQuery(selectResult);
		if(rs.next())
		{
			Statement deleteQuery=connection.createStatement();
			deleteQuery.execute(VaccinationCentreQuery.instance().deleteCentreDetails(centreCode));
			return "deleted successfully";
		}
		else
		{
			return "wrong centre code";
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return centreCode;
	}
}
