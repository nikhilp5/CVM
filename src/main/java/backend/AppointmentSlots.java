package backend;

import database.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AppointmentSlots implements IAppointmentSlots{
    private List<TimeSlots> appointmentSlots = new ArrayList<>();
    private AppointmentSlotsQuery aptQuery =  new AppointmentSlotsQuery();
    @Override
    public List<TimeSlots> getAvailableSlots(VaccinationCentreDetails vac_centre) {
        try {
            Connection connection = DatabaseConnection.instance().getDatabaseConnection();
            Statement statement = connection.createStatement();
            System.out.println("Centre_id: "+ vac_centre.centre_id);
            String aptmtQuery = aptQuery.getAppointmentSlotsQuery(vac_centre.centre_id);
            System.out.println(aptmtQuery);
            ResultSet rs = statement.executeQuery(aptmtQuery);
            if(rs.isBeforeFirst()) {
                appointmentSlots = resultAppointmentSlots(rs);
            }
            else{
                System.out.println("No Slot available at Centre: " + vac_centre.centre_id);
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return appointmentSlots;
    }
    public List<TimeSlots> resultAppointmentSlots(ResultSet rs){
        try{
            while (rs.next()) {
                System.out.println("Inside timeslot loop");
                TimeSlots timeSlot = new TimeSlots();
                timeSlot.setTime_slot_id(rs.getString(TimeSlotsDatabaseColumns.time_slot_id));
                timeSlot.setCentreId(rs.getString(TimeSlotsDatabaseColumns.centre_id));
                timeSlot.setDate(rs.getString(TimeSlotsDatabaseColumns.date));
                timeSlot.setStartTime(rs.getString(TimeSlotsDatabaseColumns.start_time));
                System.out.println("start time: "+timeSlot.getStartTime());
                timeSlot.setEndTime(rs.getString(TimeSlotsDatabaseColumns.end_time));
                appointmentSlots.add(timeSlot);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            DatabaseConnection.instance().stopDatabaseConnection();
        }
        return appointmentSlots;
    }
}
