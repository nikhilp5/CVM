package backend;

import java.util.List;

public interface IBookAppointmentController {
    public boolean addAppointment(TimeSlots slot,User user);
    public List<TimeSlots> getAvailableAppointmentSlots(VaccinationCentreDetails vac_centre);
    public List<BookAppointment> getUserAppointments(User user);
}
