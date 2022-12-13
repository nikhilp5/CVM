package frontend;

import java.util.Scanner;

import backend.TimeSlotsController;
import backend.TimeSlotsImpl;
import backend.VaccinationCentreDetails;
import backend.VaccinationCentreDetailsController;
import backend.VaccinationCentreDetailsImpl;

public class DeleteAllTimeSlots {
	private final Scanner scanner;

	public DeleteAllTimeSlots(final Scanner scanner) {
		this.scanner = scanner;
	}

	public final void deleteAll() {
		try {
			VaccinationCentreDetailsImpl vaccinationCentreDetailsImpl=new VaccinationCentreDetailsImpl();
			System.out.println("Enter Centre Code");
			final String centreCode = scanner.nextLine().trim().toLowerCase();

			VaccinationCentreDetails centre=vaccinationCentreDetailsImpl.checkVaccineCentreExists(centreCode);

			if(centre==null) {
				System.out.println("Centre doesn't Exist.Enter proper Centre Code.");
			}
			else {
				TimeSlotsImpl timeSlotsImpl=new TimeSlotsImpl();
				TimeSlotsController timeSlotsController=new TimeSlotsController(timeSlotsImpl);

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
