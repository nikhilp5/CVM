package backend;

public class AppointmentSlotsQuery {
    public String getAppointmentSlotsQuery(String centre_id){
        System.out.println("centre_id: "+centre_id);
        return "Select * From "+TimeSlotsDatabaseColumns.time_slots_table+" where "+TimeSlotsDatabaseColumns.centre_id+ " = '"+centre_id+"'";
    }
}
