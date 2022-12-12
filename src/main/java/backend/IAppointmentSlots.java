package backend;

import java.util.List;

public interface IAppointmentSlots {
    public List<TimeSlots> getAvailableSlots(VaccinationCentreDetails vac_centre);
}
