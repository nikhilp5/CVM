package frontend;

import backend.*;

import java.util.Scanner;


public class CancelAppointment {
    private final Scanner scanner;

    public CancelAppointment(Scanner scanner) {
        this.scanner = scanner;
    }

    public final void updateAppointment() {
            System.out.println("Enter First name ");
            final String firstName = scanner.nextLine().trim().toLowerCase();
            System.out.println("Enter Last name ");
            final String lastName = scanner.nextLine().trim().toLowerCase();
            System.out.println("Enter email ID ");
            final String emailId = scanner.nextLine().trim();
            
            UserUpdateImpl userUpdateImpl=new UserUpdateImpl();

            final IUserUpdateController userUpdateController = new UserUpdateController(userUpdateImpl);

            User user = userUpdateController.getUser(firstName, lastName, emailId);

            if (user == null)
            {
                System.out.println("User doesn't Exist. Enter proper Details.");
            }
            else {
                System.out.println("Enter Centre Code");
                final String centreCode = scanner.nextLine().trim().toLowerCase();
                
                VaccinationCentreDetailsImpl vaccinationCentreDetailsImpl=new VaccinationCentreDetailsImpl();

                VaccinationCentreDetails centre = vaccinationCentreDetailsImpl.checkVaccineCentreExists(centreCode);

                if (centre == null) {
                    System.out.println("Centre doesn't Exist.Enter proper Centre Code.");
                } else {
                    IDeleteAppointmentController deleteAppointmentController=new DeleteAppointmentController();
                    boolean result=deleteAppointmentController.deleteAppointmentForUserAndCentre(user,centre);
                    if(result){
                        System.out.println("Appointment deleted successfully");
                    }
                    else{
                        System.out.println("Error in Deletion");
                    }
                }
            }
    }
}