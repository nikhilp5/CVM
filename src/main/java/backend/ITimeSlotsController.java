package backend;

public interface ITimeSlotsController {
	public boolean addTimeSlot(TimeSlots timeSlotEntry);
	public boolean deleteAllTimeSlot(VaccinationCentreDetails centre);
}
