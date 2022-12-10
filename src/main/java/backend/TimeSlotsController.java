package backend;

import java.sql.Statement;
import java.util.ArrayList;

import database.IDatabaseConnection;

public class TimeSlotsController implements ITimeSlotsController{
	private final IDatabaseConnection databaseConnection;
	private final ITimeSlotsQuery  timeSlotsQuery;

	public TimeSlotsController(final IDatabaseConnection
			databaseConnection,
			final ITimeSlotsQuery
			timeSlotsQuery) {
		this.databaseConnection =databaseConnection;
		this.timeSlotsQuery =timeSlotsQuery;
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
			Statement statement = databaseConnection.getDatabaseConnection().createStatement();
		    String insertUserQuery = timeSlotsQuery.insertSlots(timeSlotEntry);
		    int rowCount=statement.executeUpdate(insertUserQuery);
		    if (rowCount > 0) {
		    	return true;
		    }
			return false;
		}
		catch(Exception e) {
			databaseConnection.stopDatabaseConnection();
			e.printStackTrace();
			return false;
		}
	}
	
	private ArrayList<String> validateInputs(TimeSlots timeSlotEntry){
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
