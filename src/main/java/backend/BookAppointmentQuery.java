package backend;

public class BookAppointmentQuery {
    public String getVaccinationCentreQuery(String user_city){
        System.out.println("User_city: "+user_city);
        return "Select * From "+VaccinationCenterDatabaseColumns.vaccination_centre_details_table+" where "+VaccinationCenterDatabaseColumns.centre_city+ "='"+user_city+"'";
    }
    
}
