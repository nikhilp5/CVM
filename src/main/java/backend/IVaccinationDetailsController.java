package backend;

import java.sql.ResultSet;

public interface IVaccinationDetailsController {
    public VaccinationDetails fetchVaccinationDetails(User user);
    public VaccinationDetails resultVaccinationDetails(ResultSet rs);
}
