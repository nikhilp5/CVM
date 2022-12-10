package backend;

public interface ITimeSlotsQuery {
	
	public String deleteSlots(String centreid);
	public String insertSlots(TimeSlots timeSlotEntry);
}
