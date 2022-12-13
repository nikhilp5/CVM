package controller;

import model.User;
import model.VaccinationCentreDetails;

public interface IDeleteAppointmentController {
    public boolean deleteAppointmentForUserAndCentre(User user,VaccinationCentreDetails centre);
}
