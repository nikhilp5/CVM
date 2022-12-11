package backend;

public class TimeSlotsController implements ITimeSlotsController{
	
	TimeSlotsImpl timeSlotsImpl=TimeSlotsImpl.instance();

	public boolean addTimeSlot(TimeSlots timeSlotEntry) {
		return timeSlotsImpl.addTimeSlot(timeSlotEntry);
	}

}
