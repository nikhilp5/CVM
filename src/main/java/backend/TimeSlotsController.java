package backend;

import java.util.ArrayList;

public class TimeSlotsController implements ITimeSlotsController{
	
	TimeSlotsImpl timeSlotsImpl=TimeSlotsImpl.instance();

	public boolean addTimeSlot(TimeSlots timeSlotEntry) {
		return timeSlotsImpl.addTimeSlot(timeSlotEntry);
	}
	
	public ArrayList<String> validateInputs(TimeSlots timeSlotEntry){
		return timeSlotsImpl.validateInputs(timeSlotEntry);
	}
}
