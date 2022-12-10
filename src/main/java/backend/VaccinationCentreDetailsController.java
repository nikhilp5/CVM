package backend;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
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
			Statement deleteSlotsQuery=connection.createStatement();
			TimeSlotsQuery vaccinationSlotsQuery=new TimeSlotsQuery();
			String deleteSlots=vaccinationSlotsQuery.deleteSlots(rs.getString("centre_id"));
			deleteSlotsQuery.execute(deleteSlots);
			Statement deleteCentreQuery=connection.createStatement();
			deleteCentreQuery.execute(VaccinationCentreQuery.instance().deleteCentreDetails(centreCode));
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
	
	public boolean addVaccinationCentreDetails(VaccinationCentreDetails vaccineCentreDetails) {
		try
		{ 
			ArrayList<String> errorList=validateVaccineCentreDetails(vaccineCentreDetails);
			if(errorList.size()!=0) {
				for(String error:errorList) {
					System.out.println(error);
				}
				return false;
			}

			Connection connection=DatabaseConnection.instance().getDatabaseConnection();
			Statement statement= connection.createStatement();
			String insertQuery=VaccinationCentreQuery.instance().addCentreDetails(vaccineCentreDetails);
			int result=statement.executeUpdate(insertQuery);
			if(result>=1)
			{
				return true;
			}
			else
			{
				return false;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		finally {
			DatabaseConnection.instance().stopDatabaseConnection();
		}
	}
	
	private ArrayList<String> validateVaccineCentreDetails(VaccinationCentreDetails vaccineCentreDetails){
		ArrayList<String> errorList=new ArrayList<String>();

		if(UserFieldValidation.isEmptyString(vaccineCentreDetails.getCentre_code())) {
			errorList.add("Centre Code is null/empty"); }
		if(UserFieldValidation.isEmptyString(vaccineCentreDetails.getCentre_name())) {
			errorList.add("Centre Name is null/empty"); }
		if(UserFieldValidation.isEmptyString(vaccineCentreDetails.getCentre_address())) {
			errorList.add("Centre Address is null/empty"); }
		if(UserFieldValidation.isEmptyString(vaccineCentreDetails.getCentre_city())) {
			errorList.add("Centre City is null/empty"); }
		if(UserFieldValidation.areaCodeValidation(vaccineCentreDetails.getCentre_zip())) {
			errorList.add("Centre Area Code is not valid"); }
		return errorList;
	}
	
	public VaccinationCentreDetails checkVaccineCentreExists(String centreCode) {
		try
		{ 
			if(UserFieldValidation.isEmptyString(centreCode)) {
				System.out.println("Centre Code is null/empty");
				return null;
			}
			Connection connection=DatabaseConnection.instance().getDatabaseConnection();
			Statement statement= connection.createStatement();
			String selectQuery=VaccinationCentreQuery.instance().validCentreNumber(centreCode);
			ResultSet rs=statement.executeQuery(selectQuery);
			if(rs.next())
			{
				VaccinationCentreDetails vaccineCentre= new VaccinationCentreDetails();
				vaccineCentre.setCentre_id(rs.getString(VaccinationCenterDatabaseColumns.centre_id));
				vaccineCentre.setCentre_name(rs.getString(VaccinationCenterDatabaseColumns.centre_name));
				vaccineCentre.setCentre_code(rs.getString(VaccinationCenterDatabaseColumns.centre_code));
				vaccineCentre.setCentre_address(rs.getString(VaccinationCenterDatabaseColumns.centre_address));
				vaccineCentre.setCentre_zip(rs.getString(VaccinationCenterDatabaseColumns.centre_zip));
				vaccineCentre.setCentre_city(rs.getString(VaccinationCenterDatabaseColumns.centre_city));
				return vaccineCentre;
			}
			else
			{
				return null;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}	
		finally {
			DatabaseConnection.instance().stopDatabaseConnection();
		}
	}
}
