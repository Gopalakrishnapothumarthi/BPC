import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PatientTest {
    private Patient patient;

    @BeforeEach
    public void setup() {
        patient = new Patient(1, "John Doe", "123 Main St", "123-4567");
    }

    @Test
    public void testPatientInitialization() {
        assertEquals("John Doe", patient.getName());
        assertNotNull(patient.getAppointments());
        assertEquals(0, patient.getAppointments().size());
    }

    @Test
    public void testBookAppointmentAddsAppointment() {
        Appointment appointment = new Appointment(
                101,
                new Treatment("Physical Therapy"),
                LocalDateTime.of(2025, 4, 15, 10, 0),
                patient,
                new Physiotherapist(1, "Dr. Smith", "Clinic", "999", List.of("Rehabilitation"))
        );

        patient.bookAppointment(appointment);

        List<Appointment> appointments = patient.getAppointments();
        assertEquals(1, appointments.size());
        assertEquals(appointment, appointments.get(0));
    }
}
