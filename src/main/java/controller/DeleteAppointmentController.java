package controller;

import model.BookAppointmentImpl;
import model.User;
import model.VaccinationCentreDetails;

public class DeleteAppointmentController implements IDeleteAppointmentController{

    BookAppointmentImpl bookAppointmentImpl;
    
    public DeleteAppointmentController(BookAppointmentImpl bookAppointmentImpl) {
    	this.bookAppointmentImpl=bookAppointmentImpl;
    }

    public boolean deleteAppointmentForUserAndCentre(User user,VaccinationCentreDetails centre){
        return bookAppointmentImpl.deleteAppointmentForUserAndCentre(user,centre);
    }
}
