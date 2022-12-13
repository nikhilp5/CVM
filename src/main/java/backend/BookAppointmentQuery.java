package backend;

public class BookAppointmentQuery {
    public String getAppointmentSlotsQuery(String centre_id){
        System.out.println("centre_id: "+centre_id);
        return "Select * From "+TimeSlotsDatabaseColumns.time_slots_table+" where "+TimeSlotsDatabaseColumns.centre_id+ " = '"+centre_id+"'";
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
