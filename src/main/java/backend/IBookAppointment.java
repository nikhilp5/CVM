package backend;

import java.util.List;
import java.util.Map;

public interface IBookAppointment {
    public Map<String, String> getAvailableSlots(VaccinationCentreDetails vac_centre);
    public List<VaccinationCentreDetails> getVaccinationCentres(User user);
}
