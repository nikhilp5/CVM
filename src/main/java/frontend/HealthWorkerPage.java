package frontend;

import java.util.Scanner;

public class HealthWorkerPage {

    private void updateUser(final Scanner scanner) {
        final UpdateUser updateUser = new UpdateUser(scanner);
        updateUser.update();
    }

    private void cancelAppointment() {
    }

    public void display() {
        final Scanner scanner = new Scanner(System.in);
        final HealthWorkerPage healthWorkerPage = new HealthWorkerPage();
        System.out.println("Welcome Health Worker \nSelect an option");
        boolean logout = true;
        while (logout) {
            System.out.println("1. Update User\n"
                    + "2. Cancel Appointment\n "
                    + "3. Logout\n");
            final String input = scanner.nextLine();
            switch (input) {
                case "1":
                    healthWorkerPage.updateUser(scanner);
                    break;
                case "2":
                    healthWorkerPage.cancelAppointment();
                    break;
                case "3":
                default:
                    System.out.println("enter the correct option");
                    break;
            }

        }
    }
}
