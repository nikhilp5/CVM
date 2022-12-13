package controller;

import model.TimeSlots;
import model.VaccinationCentreDetails;

public interface ITimeSlotsController {
	public boolean addTimeSlot(TimeSlots timeSlotEntry);
	public boolean deleteAllTimeSlot(VaccinationCentreDetails centre);
}
