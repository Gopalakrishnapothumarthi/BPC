import java.util.ArrayList;
import java.util.List;

public class Patient {
    private int id;
    private String name;
    private String address;
    private String phone;
    private List<Appointment> appointments = new ArrayList<>();
    public Patient(int id, String name, String address, String phone){
        this.id=id;
        this.name=name;
        this.address=address;
        this.phone=phone;
        this.appointments=new ArrayList<>();
    }

    public void bookAppointments(Appointment appointment){
        appointments.add(appointment);
    }
    public boolean cancelAppointment(Appointment appointment){
        return appointments.remove(appointment);
    }
    public List<Appointment> getAppointments() {
        return appointments;
    }
    public String getName(){
        return name;
    }
}
