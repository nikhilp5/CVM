package frontend;

import backend.BookAppointment;
import backend.User;
import backend.VaccinationCentreDetails;
import backend.VaccinationDetails;

import java.util.List;
import java.util.Scanner;

public class BookAppointmentView {
    VaccinationCentreDetails vac_center;
    Scanner scanner = new Scanner(System.in);
    private List<VaccinationCentreDetails> vac_centres;
    public void bookAppoinment(User user, VaccinationDetails vac_details) {
        while (true) {
            System.out.println("Book Your Appointment \n Select a vaccination centre: ");
            int total = showVaccinationCentres(user, vac_details);
            String input = scanner.nextLine();
            int index = Integer.parseInt(input);
            index= index - 1 ;
            System.out.println("List size: " + vac_centres.size());
            if(index < vac_centres.size()){
                vac_centres.get(index).getCentre_name();
                break;
            }
            else{
                System.out.println(" Incorrect Centre selection !!");
            }
        }
    }
    public int showVaccinationCentres(User user, VaccinationDetails vac_details) {
        int index = 1;
        if (vac_details.getVaccination_status().contains("fully")) {
            System.out.println("User fully vaccinated !!!");
        }
        else {
            BookAppointment bk = new BookAppointment();
            vac_centres = bk.getVaccinationCentres(user);
            System.out.println("Vaccine Centres: ");
            for (VaccinationCentreDetails vac_centre : vac_centres) {
                System.out.println(index + " " + vac_centre.getCentre_name());
                System.out.println("Centre code: "+ vac_centre.getCentre_code());
                System.out.println("Address: "+ vac_centre.getCentre_address());
                index++;
            }
        }
        return index;
    }
}