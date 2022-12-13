package backend;

public interface IDeleteAppointmentController {
    public boolean deleteAppointmentForUserAndCentre(User user,VaccinationCentreDetails centre);
}
