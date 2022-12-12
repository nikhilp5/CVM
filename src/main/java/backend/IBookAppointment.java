package backend;

import java.util.List;
import java.util.Map;

public interface IBookAppointment {
    public List<VaccinationCentreDetails> getVaccinationCentres(User user);
}
