package view;

import controller.VaccinationCentreDetailsController;
import model.*;

import java.util.ArrayList;
import java.util.List;

public class ShowVaccinationCentres {
    List<VaccinationCentreDetails> vac_centres = new ArrayList<>();
    public List<VaccinationCentreDetails> showVaccinationCentres(User user) {
        int index = 1;
        VaccinationCentreDetailsImpl vaccinationCentreDetails=new VaccinationCentreDetailsImpl();
        VaccinationCentreDetailsController vac_ctrl = new VaccinationCentreDetailsController(vaccinationCentreDetails);
        vac_centres = vac_ctrl.selectVaccinationCentres(user);
        System.out.println("Vaccine Centres: ");
        for (VaccinationCentreDetails vac_centre : vac_centres) {
            System.out.println(index + " " + vac_centre.getCentre_name());
            System.out.println("Centre code: "+ vac_centre.getCentre_code());
            System.out.println("Address: "+ vac_centre.getCentre_address());
            index++;
        }
        return vac_centres;
    }
}
