package backend;

public class TimeSlotsQuery implements ITimeSlotsQuery {

	@Override
	public String deleteSlots(String centreid) {
			return "Delete From "+TimeSlotsDatabaseColumns.time_slots_table+
					" where "+TimeSlotsDatabaseColumns.centre_id+ "="+centreid;
	}

}
