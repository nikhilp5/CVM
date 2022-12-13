package view.appointment;

import java.util.List;
import java.util.Scanner;

import model.user.User;
import model.vaccinationCentre.VaccinationCentreDetails;

public class BookAppointmentView {
    ShowAppointmentSlots apt = new ShowAppointmentSlots();
    User newUser;
    Scanner scanner = new Scanner(System.in);
    private List<VaccinationCentreDetails> vac_centres;
    public void bookAppointment(User user, List<VaccinationCentreDetails> vac_centre_list) {
        while (true) {
            newUser = user;
            vac_centres = vac_centre_list;
            String input = scanner.nextLine();
            int index = Integer.parseInt(input);
            index= index - 1 ;
            if(index < vac_centres.size()){
                apt.showAvailableSlots(vac_centres.get(index));
                input = scanner.nextLine();
                index = Integer.parseInt(input);
                index= index - 1;
                if(apt.checkUserAppointmentSlot(index, user)) {
                    System.out.println("Your Appointment Booked !!!!..");
                    apt.showBookedAppointment(user);
                    break;
                }
            }
            else{
                System.out.println("Incorrect Centre Selection !!");
            }
        }
    }

}