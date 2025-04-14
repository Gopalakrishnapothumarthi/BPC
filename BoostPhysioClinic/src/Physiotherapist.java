import java.util.*;

public class Physiotherapist {
    private int id;
    private String name;
    private String address;
    private String phone;
    private List<String> expertise;
    private List<Appointment> schedule;
    public Physiotherapist(int id, String name, String address, String phone, List<String> expertise) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.expertise = expertise;
        this.schedule = new ArrayList<>();
    }
    public List<Appointment> getAvailableAppointments(){
        return schedule;
    }
    public void addAppointment(Appointment appointment){
        schedule.add(appointment);
    }
    public List<Appointment> removeAppointment(){
        return schedule;
    }

    public String getName() {
        return name;
    }
}
