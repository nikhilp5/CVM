package controller.vaccinationDetails;

import java.sql.ResultSet;

import model.user.User;
import model.vaccinationDetails.VaccinationDetails;

public interface IVaccinationDetailsController {
    public VaccinationDetails fetchVaccinationDetails(User user);
    public VaccinationDetails resultVaccinationDetails(ResultSet rs);
}
