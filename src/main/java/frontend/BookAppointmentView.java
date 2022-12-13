package frontend;

import backend.*;

import java.util.List;
import java.util.Scanner;

public class BookAppointmentView {
    ShowAppointmentSlots apt = new ShowAppointmentSlots();
    VaccinationCentreDetails vac_center;
    BookAppointmentImpl bk1 = new BookAppointmentImpl();
    User newUser;
    Scanner scanner = new Scanner(System.in);
    private List<VaccinationCentreDetails> vac_centres;
    public void bookAppointment(User user, VaccinationDetails vac_details) {
        while (true) {
            System.out.println("Book Your Appointment \n Select a vaccination centre: ");
            showVaccinationCentres(user, vac_details);
            newUser = user;
            String input = scanner.nextLine();
            int index = Integer.parseInt(input);
            index= index - 1 ;
            System.out.println("List size: " + vac_centres.size());
            if(index < vac_centres.size()){
                apt.showAvailableSlots(vac_centres.get(index));
                input = scanner.nextLine();
                index = Integer.parseInt(input);
                index= index - 1;
                if(apt.checkUserAppointmentSlot(index, user)) {
                    break;
                }
            }
            else{
                System.out.println(" Incorrect Centre selection !!");
            }
        }
    }
    public void showVaccinationCentres(User user, VaccinationDetails vac_details) {
        int index = 1;
        if (vac_details.getVaccination_status().contains("fully")) {
            System.out.println("User fully vaccinated !!!");
        }
        else {
            BookAppointmentImpl bk = new BookAppointmentImpl();
            vac_centres = VaccinationCentreDetailsImpl.instance().getVaccinationCentres(user);
            System.out.println("Vaccine Centres: ");
            for (VaccinationCentreDetails vac_centre : vac_centres) {
                System.out.println(index + " " + vac_centre.getCentre_name());
                System.out.println("Centre code: "+ vac_centre.getCentre_code());
                System.out.println("Address: "+ vac_centre.getCentre_address());
                index++;
            }
        }
    }
}