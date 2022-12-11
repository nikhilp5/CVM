package backend;

import java.sql.Statement;
import java.util.ArrayList;

import database.DatabaseConnection;

public class TimeSlotsImpl {

	private static TimeSlotsImpl timeSlotsImpl;

	public static TimeSlotsImpl instance() {
		if (timeSlotsImpl == null) {
			timeSlotsImpl = new TimeSlotsImpl();
		}
		return timeSlotsImpl;
	}
	
	public boolean addTimeSlot(TimeSlots timeSlotEntry) {
		try {
			ArrayList<String> errorList=validateInputs(timeSlotEntry);
			if(errorList.size()!=0) {
				for(String error:errorList) {
					System.out.println(error);
				}
				return false;
			}
			Statement statement = DatabaseConnection.instance().getDatabaseConnection().createStatement();
			String insertUserQuery = TimeSlotsQuery.instance().insertSlots(timeSlotEntry);
			int rowCount=statement.executeUpdate(insertUserQuery);
			if (rowCount > 0) {
				return true;
			}
			return false;
		}
		catch(Exception e) {
			DatabaseConnection.instance().stopDatabaseConnection();
			e.printStackTrace();
			return false;
		}
	}
	
	public ArrayList<String> validateInputs(TimeSlots timeSlotEntry){
		ArrayList<String> errorList=new ArrayList<String>();

		if(UserFieldValidation.dateValidation(timeSlotEntry.getDate())) {
			errorList.add("Date is not Valid"); }
		if(UserFieldValidation.timeValidation(timeSlotEntry.getStartTime())) {
			errorList.add("Start time is not Valid"); }
		if(UserFieldValidation.timeValidation(timeSlotEntry.getEndTime())) {
			errorList.add("End time is not Valid"); }
		return errorList;
	}
}
