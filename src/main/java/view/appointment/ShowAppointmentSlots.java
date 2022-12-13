package view.appointment;

import controller.bookAppointment.BookAppointmentController;
import model.bookAppointment.BookAppointment;
import model.timeSlots.TimeSlots;
import model.user.User;
import model.vaccinationCentre.VaccinationCentreDetails;

import java.util.List;

public class ShowAppointmentSlots {
    BookAppointmentController bk_ctrl = new BookAppointmentController();
    TimeSlots slot = new TimeSlots();
    private List<TimeSlots> timeSlots;
    public void showAvailableSlots(VaccinationCentreDetails vac_details){
        int index=1;
        System.out.println("centre_name: "+ vac_details.getCentre_name()+" id: "+ vac_details.centre_id);
        timeSlots = bk_ctrl.getAvailableAppointmentSlots(vac_details);
        if(timeSlots.isEmpty())
        {
         System.out.println("No Time Slot Available at this Centre !!");
        }
        else {
            for (TimeSlots timeSlot : timeSlots) {
                System.out.println(index + " Date: " + timeSlot.getDate());
                System.out.println("Time: " + timeSlot.getStartTime() + " " + timeSlot.getEndTime());
                index++;
            }
        }
    }
    public boolean checkUserAppointmentSlot(int index, User user){
        boolean flag = false;
        if(index < timeSlots.size()){
            slot = timeSlots.get(index);
            if(bk_ctrl.addAppointment(slot,user)) {
                flag = true;
            }
        }
        else{
            flag = false;
        }
        return flag;
    }

    public void showBookedAppointment(User user)
    {
        List<BookAppointment> bookedAppointments;
        if(bk_ctrl.IsAppointmentExist(user)){
            int index = 1;
            bookedAppointments = bk_ctrl.getUserAppointments(user);
            for (BookAppointment bookAppointment : bookedAppointments){
                System.out.println(index + " user_id " + bookAppointment.getUser_id()+" Centre_id: "+ bookAppointment.getCentre_id()+" Time_slot_id: "+ bookAppointment.getTime_slot_id());
                index++;
            }
        }
        else{
            System.out.println("No Appointment Found !!");
        }
    }

}
