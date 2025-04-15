import java.util.ArrayList;
import java.util.List;

public class Patient {
    private int id;
    private String name;
    private String address;
    private String contactInfo;
    private List<Appointment> appointments;

    public Patient(int id, String name, String address, String contactInfo) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contactInfo = contactInfo;
        this.appointments = new ArrayList<>();
    }

    public void bookAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    public String getName() {
        return name;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }
}
