package controller.vaccinationDetails;

import database.DatabaseConnection;
import model.user.User;
import model.vaccinationDetails.VaccinationDetails;
import model.vaccinationDetails.VaccinationDetailsDatabaseColumns;
import model.vaccinationDetails.VaccinationDetailsImpl;
import model.vaccinationDetails.VaccinationDetailsQuery;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class VaccinationDetailsController implements IVaccinationDetailsController{
    private VaccinationDetails vac_details = new VaccinationDetails();
    private VaccinationDetailsImpl vac_impl = new VaccinationDetailsImpl();
    
    @Override
    public VaccinationDetails fetchVaccinationDetails(User user) {
        try {
            vac_details = vac_impl.selectVaccinationDetails(user);
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return vac_details;
    }

}
