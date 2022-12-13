package controller;

import java.util.List;

import model.BookAppointment;
import model.TimeSlots;
import model.User;
import model.VaccinationCentreDetails;

public interface IBookAppointmentController {
    public boolean addAppointment(TimeSlots slot,User user);
    public List<TimeSlots> getAvailableAppointmentSlots(VaccinationCentreDetails vac_centre);
    public List<BookAppointment> getUserAppointments(User user);
}
