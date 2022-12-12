package frontend;
import java.util.Scanner;

import backend.ITimeSlotsQuery;
import backend.TimeSlots;
import backend.TimeSlotsController;
import backend.TimeSlotsQuery;
import backend.VaccinationCentreDetails;
import backend.VaccinationCentreDetailsImpl;
import database.DatabaseConnection;
import database.IDatabaseConnection;

public class AddTimeSlots {
	private final IDatabaseConnection databaseConnection;
	private final ITimeSlotsQuery timeSlotsQuery;
	private final Scanner scanner;

	public AddTimeSlots(final Scanner scanner) {
		this.scanner = scanner;
		databaseConnection = DatabaseConnection.instance();
		timeSlotsQuery=TimeSlotsQuery.instance();
	}
	
	public final void add() {
		try {
			System.out.println("Enter Centre Code");
			final String centreCode = scanner.nextLine().trim().toLowerCase();

			VaccinationCentreDetails centre=VaccinationCentreDetailsImpl.instance().checkVaccineCentreExists(centreCode);

			if(centre==null) {
				System.out.println("Centre doesn't Exist.Enter proper Centre Code.");
			}
			else {
				this.addTimeSlots(centre);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally{
			databaseConnection.stopDatabaseConnection();
		}
	}
	
		public final void addTimeSlots(VaccinationCentreDetails centre) {
		try {	
			System.out.println("Enter Date");
			final String date = scanner.nextLine().trim();
			System.out.println("Enter Start time(24 hours format ex.13:00 for 1 pm)");
			final String startTime = scanner.nextLine().trim();
			System.out.println("Enter End time(24 hours format ex.13:00 for 1 pm)");
			final String endTime = scanner.nextLine().trim();
			
			TimeSlots timeSlotEntry=new TimeSlots();
			timeSlotEntry.setCentreId(centre.getCentre_id());
			timeSlotEntry.setDate(date);
			timeSlotEntry.setStartTime(startTime);
			timeSlotEntry.setEndTime(endTime);
			

			TimeSlotsController timeSlotsController=new TimeSlotsController();
			
			boolean timeSlotInserted=timeSlotsController.addTimeSlot(timeSlotEntry);
			
			if(timeSlotInserted) {
				 System.out.println("Time Slot added succesfully");
			 }
			 else {
				 System.out.println("Time Slot not added");
			 }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			 databaseConnection.stopDatabaseConnection();
		}
	}
}
