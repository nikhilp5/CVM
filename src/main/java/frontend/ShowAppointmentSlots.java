package frontend;

import backend.*;

import java.util.List;

public class ShowAppointmentSlots {
    BookAppointmentImpl bk1 = new BookAppointmentImpl();
    TimeSlots slot = new TimeSlots();
    private List<TimeSlots> timeSlots;
    public void showAvailableSlots(VaccinationCentreDetails vac_details){
        int index=1;
        System.out.println("centre_name: "+ vac_details.getCentre_name()+" id: "+ vac_details.centre_id);
        timeSlots = bk1.getAvailableAppointmentSlots(vac_details);
        System.out.println("Available Time Slots for Centre: "+ vac_details.getCentre_name());
        System.out.println("time_slot size: "+timeSlots.size());
        for (TimeSlots timeSlot : timeSlots){
            System.out.println(index + " Date: " + timeSlot.getDate());
            System.out.println("Time: " +timeSlot.getStartTime()+" "+ timeSlot.getEndTime());
            index++;
        }
    }
    public boolean checkUserAppointmentSlot(int index,User user){
        boolean flag = false;
        if(index < timeSlots.size()){
            slot = timeSlots.get(index);
            if(bk1.bookAppointment(slot,user)) {
                flag = true;
            }
        }
        else{
            flag = false;
        }
        return flag;
    }

    public void showBookedAppointment()
    {

    }

}
