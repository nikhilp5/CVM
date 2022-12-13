package backend;

public class BookAppointmentQuery {
    public String getVaccinationCentreQuery(String user_city){
        System.out.println("User_city: "+user_city);
        return "Select * From "+VaccinationCenterDatabaseColumns.vaccination_centre_details_table+" where "+VaccinationCenterDatabaseColumns.centre_city+ "='"+user_city+"'";
    }
    public String insertAppointment(User user, TimeSlots apt) {
        return "insert into " + BookAppointmentDatabaseColumns.bookAppointment_table+ "(" +
                BookAppointmentDatabaseColumns.user_id + ", " +
                BookAppointmentDatabaseColumns.centre_id + ", " +
                BookAppointmentDatabaseColumns.time_slot_id + ")" +
                "values (" +
                "'" + user.getUserId() + "', " +
                "'" + apt.getCentreId() + "', " +
                "'" + apt.getTime_slot_id()+ "');";
    }
    public String deleteAppointmentByTimeSlot(String centreId) {
        return "delete from "+ BookAppointmentDatabaseColumns.bookAppointment_table+
        		" where "+BookAppointmentDatabaseColumns.centre_id+
        		" in ('"+centreId+"')";
    }
}
