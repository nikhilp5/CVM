package controller;

import java.sql.ResultSet;

import model.User;
import model.VaccinationDetails;

public interface IVaccinationDetailsController {
    public VaccinationDetails fetchVaccinationDetails(User user);
    public VaccinationDetails resultVaccinationDetails(ResultSet rs);
}
