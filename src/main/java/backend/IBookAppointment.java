package backend;

import java.util.List;

public interface IBookAppointment {
    public boolean bookAppointment(TimeSlots slot,User user);
    public List<TimeSlots> getAvailableAppointmentSlots(VaccinationCentreDetails vac_centre);
}
