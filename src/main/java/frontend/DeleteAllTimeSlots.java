package frontend;

import java.util.Scanner;

import backend.TimeSlotsController;
import backend.VaccinationCentreDetails;
import backend.VaccinationCentreDetailsImpl;

public class DeleteAllTimeSlots {
	private final Scanner scanner;

	public DeleteAllTimeSlots(final Scanner scanner) {
		this.scanner = scanner;
	}

	public final void deleteAll() {
		try {
			System.out.println("Enter Centre Code \n");
			final String centreCode = scanner.nextLine().trim().toLowerCase();

			VaccinationCentreDetails centre=VaccinationCentreDetailsImpl.instance().checkVaccineCentreExists(centreCode);

			if(centre==null) {
				System.out.println("Centre doesn't Exist.Enter proper Centre Code. \n");
			}
			else {
				TimeSlotsController timeSlotsController=new TimeSlotsController();

				boolean timeSlotInserted=timeSlotsController.deleteAllTimeSlot(centre);

				if(timeSlotInserted) {
					System.out.println("Time Slot delete for centre "+centre.getCentre_name());
				}
				else {
					System.out.println("Time Slots not deleted");
				}
			}

		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
