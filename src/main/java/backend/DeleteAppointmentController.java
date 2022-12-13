package backend;

public class DeleteAppointmentController implements IDeleteAppointmentController{

    BookAppointmentImpl bookAppointmentImpl=new BookAppointmentImpl();

    public boolean deleteAppointmentForUserAndCentre(User user,VaccinationCentreDetails centre){
        return bookAppointmentImpl.deleteAppointmentForUserAndCentre(user,centre);
    }
}
