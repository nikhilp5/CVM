package model.bookAppointment;

import database.DatabaseConnection;
import model.timeSlots.TimeSlots;
import model.timeSlots.TimeSlotsDatabaseColumns;
import model.vaccinationCentre.VaccinationCentreDetails;
import model.user.User;

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
    private List<BookAppointment> bookedAppointments = new ArrayList<>();
    @Override
    public boolean bookAppointment(TimeSlots slot, User user){
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

    public boolean deleteAppointmentForUserAndCentre(User user,VaccinationCentreDetails centre){
        try {
            Statement statement = DatabaseConnection.instance().getDatabaseConnection().createStatement();
            String deleteSlotsQuery = book_query.deleteAppointmentForUserAndCentre(user.getUserId(),centre.getCentre_id());
            int rowCount = statement.executeUpdate(deleteSlotsQuery);
            if (rowCount >= 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            DatabaseConnection.instance().stopDatabaseConnection();
            e.printStackTrace();
            return false;
        }
    }
    public List<BookAppointment> getBookedAppointments(User user){
        try{
            Connection connection = DatabaseConnection.instance().getDatabaseConnection();
            Statement statement = connection.createStatement();
            String bookedQuery = book_query.getBookedAppointmentQuery(user.getUserId());
            System.out.println(bookedQuery);
            ResultSet rs = statement.executeQuery(bookedQuery);
            if(rs.isBeforeFirst()) {
                bookedAppointments = resultBookedAppointments(rs);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            DatabaseConnection.instance().stopDatabaseConnection();
        }
        return bookedAppointments;
    }
    public List<BookAppointment> resultBookedAppointments(ResultSet rs){
        try{
            while (rs.next()) {
                BookAppointmentImpl bookAppointment = new BookAppointmentImpl();
                bookAppointment.setCentre_id(rs.getString(BookAppointmentDatabaseColumns.centre_id));
                bookAppointment.setTime_slot_id(rs.getString(BookAppointmentDatabaseColumns.time_slot_id));
                System.out.println(bookAppointment.getTime_slot_id());
                bookAppointment.setUser_id(rs.getString(BookAppointmentDatabaseColumns.user_id));
                bookedAppointments.add(bookAppointment);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            DatabaseConnection.instance().stopDatabaseConnection();
        }
        return bookedAppointments;
    }

}

