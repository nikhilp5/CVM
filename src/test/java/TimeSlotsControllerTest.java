import java.sql.Statement;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import backend.TimeSlotsController;
import backend.TimeSlotsDatabaseColumns;
import backend.TimeSlotsQuery;
import backend.VaccinationCentreDetails;
import backend.ITimeSlotsController;
import backend.ITimeSlotsQuery;
import backend.TimeSlots;
import database.DatabaseConnection;
import database.IDatabaseConnection;

public class TimeSlotsControllerTest {
	public final IDatabaseConnection databaseConnection=DatabaseConnection.instance();
	public final ITimeSlotsQuery  timeSlotsQuery=TimeSlotsQuery.instance();
	final ITimeSlotsController timeSlotsController = new TimeSlotsController();
	
	@Test
	public void addTimeSlotTest() {
		try {
			String queryForDeletionAfterTest="delete from "+TimeSlotsDatabaseColumns.time_slots_table
					+" where "+ TimeSlotsDatabaseColumns.centre_id
					+" =999";
			TimeSlots timeSlotEntry=new TimeSlots ("99:99", "99:99","999", "99-99-9999");
			Assertions.assertFalse(timeSlotsController.addTimeSlot(timeSlotEntry));
			timeSlotEntry=new TimeSlots ("13:00", "15:00","999", "10-10-2020");
			Assertions.assertTrue(timeSlotsController.addTimeSlot(timeSlotEntry));
			Statement statement = databaseConnection.getDatabaseConnection().createStatement();
			statement.executeUpdate(queryForDeletionAfterTest);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally{
			databaseConnection.stopDatabaseConnection();
		}
	}

	@Test
	public void deleteTimeSlotTest() {
		try {
			TimeSlots timeSlotEntry=new TimeSlots ("13:00", "15:00","999", "10-10-2020");
			timeSlotsController.addTimeSlot(timeSlotEntry);
			VaccinationCentreDetails centre=new VaccinationCentreDetails();
			centre.setCentre_id("999");
			Assertions.assertTrue(timeSlotsController.deleteAllTimeSlot(centre));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally{
			databaseConnection.stopDatabaseConnection();
		}
	}
}
