package controller.userUpdate;

import model.user.User;
import model.vaccinationCentre.VaccinationCentreDetails;
import model.vaccinationDetails.VaccinationDetails;

public interface IVaccineUpdateController {

    public boolean updateVaccinationStatus(User user);
}
