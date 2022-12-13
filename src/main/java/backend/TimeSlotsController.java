package backend;

public class TimeSlotsController implements ITimeSlotsController{
	
	TimeSlotsImpl timeSlotsImpl=TimeSlotsImpl.instance();

	public boolean addTimeSlot(TimeSlots timeSlotEntry) {
		return timeSlotsImpl.addTimeSlot(timeSlotEntry);
	}

	public boolean deleteAllTimeSlot(VaccinationCentreDetails centre) {
		return timeSlotsImpl.deleteAllTimeSlot(centre);
	}

	public boolean deleteTimeSlotForUserAndCentre(User user,VaccinationCentreDetails centre){
		return timeSlotsImpl.deleteTimeSlotForUserAndCentre(user,centre);
	}
}
