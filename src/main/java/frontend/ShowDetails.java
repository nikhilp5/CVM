package frontend;

import backend.User;
import backend.VaccinationDetails;
import backend.VaccinationDetailsController;

public class ShowDetails extends User implements IShowDetails{
    @Override
    public void showUserDetails(User user) {
        System.out.println("Name: "+user.getFirstName()+" "+ user.getLastName());
        System.out.println("DOB: "+user.getDateOfBirth());
        System.out.println("Gender: "+user.getGender());
        System.out.println("Address: "+user.getAddress()+" "+user.getAddressZipCode()+" "+user.getAddressCity());
    }

    @Override
    public void showVaccinationDetails(User user) {
        try {
            VaccinationDetailsController vac_con = new VaccinationDetailsController();
            VaccinationDetails vac_details = vac_con.fetchVaccinationDetails(user);
            System.out.println(vac_details.getVaccination_status());
            if(vac_details.getVaccination_status().contains("vaccinated")) {
                System.out.println("Vaccination_status: "+vac_details.getVaccination_status());
                System.out.println("Vaccine Name: " + vac_details.getVaccine_name());
                System.out.println("Dose 1: " + vac_details.getDose1());
                System.out.println("Dose 1 Date: " + vac_details.getDose1_date());
                System.out.println("Dose 1 HealthWorker: " + vac_details.getDose1_healthWorker());
                System.out.println("Dose 1 VaccinationCenter: " + vac_details.getDose1_vaccinationCenter());
                if(vac_details.getVaccination_status().contains("fully_vaccinated")) {
                    System.out.println("Dose 2: " + vac_details.getDose2());
                    System.out.println("Dose 2 Date: " + vac_details.getDose2_date());
                    System.out.println("Dose 2 HealthWorker: " + vac_details.getDose2_healthWorker());
                    System.out.println("Dose 2 VaccinationCenter: " + vac_details.getDose2_vaccinationCenter());
                }
            }
            else {
                System.out.println("Not Vaccinated ");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

}
