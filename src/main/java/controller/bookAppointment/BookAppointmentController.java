package controller.bookAppointment;

import java.util.List;

import model.bookAppointment.BookAppointment;
import model.bookAppointment.BookAppointmentImpl;
import model.timeSlots.TimeSlots;
import model.user.User;
import model.vaccinationCentre.VaccinationCentreDetails;

public class BookAppointmentController implements IBookAppointmentController{
    BookAppointmentImpl bookImpl = new BookAppointmentImpl();

    @Override
    public boolean addAppointment(TimeSlots slot,User user){
        boolean result = false;
        try {
            result = bookImpl.bookAppointment(slot, user);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
    @Override
    public List<TimeSlots> getAvailableAppointmentSlots(VaccinationCentreDetails vac_centre){
        List<TimeSlots> timeSlots = null;
        try {
            timeSlots = bookImpl.getAvailableAppointmentSlots(vac_centre);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return timeSlots;
    }
    @Override
    public List<BookAppointment> getUserAppointments(User user){
        List<BookAppointment> bookedAppointments = null;
        try{
            bookedAppointments = bookImpl.getBookedAppointments(user);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return bookedAppointments;
    }
    public boolean IsAppointmentExist(User user){
        List<BookAppointment> bookAppointments = getUserAppointments(user);
        if(bookAppointments.isEmpty()){
            return true;
        }
        return false;
    }
}
