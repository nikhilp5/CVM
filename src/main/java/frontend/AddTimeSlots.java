package frontend;

import java.util.Scanner;

import backend.ITimeSlotsController;
import backend.TimeSlots;
import backend.TimeSlotsController;
import backend.VaccinationCentreDetails;
import backend.VaccinationCentreDetailsController;

public class AddTimeSlots {
	private final Scanner scanner;

	public AddTimeSlots(final Scanner scanner) {
		this.scanner = scanner;
	}
	
	public final void add() {
		try {
			System.out.println("Enter Centre Code");
			final String centreCode = scanner.nextLine().trim().toLowerCase();

			VaccinationCentreDetails centre=VaccinationCentreDetailsController.instance().checkVaccineCentreExists(centreCode);

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
			
			final ITimeSlotsController timeSlotsController = new TimeSlotsController();
			
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
	}
}
