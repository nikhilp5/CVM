package backend;

import database.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookAppointmentImpl extends BookAppointment implements IBookAppointment{
    BookAppointmentQuery book_query = new BookAppointmentQuery();
    public BookAppointmentImpl(){
        super();
    }

    private List<TimeSlots> appointmentSlots = new ArrayList<>();
    @Override
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
    @Override
    public List<TimeSlots> getAvailableAppointmentSlots(VaccinationCentreDetails vac_centre) {
        try {
            Connection connection = DatabaseConnection.instance().getDatabaseConnection();
            Statement statement = connection.createStatement();
            System.out.println("Centre_id: "+ vac_centre.centre_id);
            String aptmtQuery = book_query.getAppointmentSlotsQuery(vac_centre.centre_id);
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

