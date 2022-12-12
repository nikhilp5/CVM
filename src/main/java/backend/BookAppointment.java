package backend;

import database.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookAppointment implements IBookAppointment{
    BookAppointmentQuery book_query = new BookAppointmentQuery();
    List<VaccinationCentreDetails> vac_centres = new ArrayList<VaccinationCentreDetails>();

    @Override
    public List<VaccinationCentreDetails> getVaccinationCentres(User user) {
        try {
            Connection connection = DatabaseConnection.instance().getDatabaseConnection();
            Statement statement = connection.createStatement();
            String vacCentreQuery = book_query.getVaccinationCentreQuery(user.getAddressCity());
            ResultSet rs = statement.executeQuery(vacCentreQuery);
            if(rs.isBeforeFirst()) {
                vac_centres = resultVaccinationCentres(rs);
                System.out.println("No of centres: "+ vac_centres.size());
            }
            else{
                System.out.println("No vaccination centre available");
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return vac_centres;
    }
    public List<VaccinationCentreDetails> resultVaccinationCentres(ResultSet rs){
        try{
            while (rs.next()) {
                VaccinationCentreDetails vac_centre = new VaccinationCentreDetails();
                vac_centre.setCentre_id(rs.getString(VaccinationCenterDatabaseColumns.centre_id));
                vac_centre.setCentre_city(rs.getString(VaccinationCenterDatabaseColumns.centre_city));
                vac_centre.setCentre_name(rs.getString(VaccinationCenterDatabaseColumns.centre_name));
                vac_centre.setCentre_address(rs.getString(VaccinationCenterDatabaseColumns.centre_address));
                vac_centre.setCentre_code(rs.getString(VaccinationCenterDatabaseColumns.centre_code));
                vac_centre.setCentre_zip(rs.getString(VaccinationCenterDatabaseColumns.centre_zip));
                vac_centres.add(vac_centre);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            DatabaseConnection.instance().stopDatabaseConnection();
        }
        return vac_centres;
    }
    public boolean bookAppointment(TimeSlots slot,User user){
        boolean flag = false;
        try {
            Statement statement = DatabaseConnection.instance().getDatabaseConnection().createStatement();
            String bookAppointmentQuery = book_query.insertAppointment(user, slot);
            int rowCount = statement.executeUpdate(bookAppointmentQuery);
            if(rowCount > 0){
                flag = true;
            }
            else{
                flag = false;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            DatabaseConnection.instance().stopDatabaseConnection();
        }
        return flag;
    }
}

