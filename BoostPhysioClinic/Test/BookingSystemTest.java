import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BookingSystemTest {

    private BookingSystem bookingSystem;
    private Patient patient;
    private Physiotherapist physio;
    private Appointment appointment;

    @BeforeEach
    public void setup() {
        bookingSystem = new BookingSystem();

        patient = new Patient(1, "John Doe", "123 Main St", "123-4567");
        physio = new Physiotherapist(1, "Dr. Smith", "Clinic Address", "555-9999", List.of("Back Pain"));

        bookingSystem.addPatient(patient);

        appointment = new Appointment(
                101,
                new Treatment("Physio Session"),
                LocalDateTime.of(2025, 4, 20, 10, 0),
                patient,
                physio
        );
    }

    @Test
    public void testAddPatient() {
        Patient newPatient = new Patient(2, "Jane Doe", "456 Oak St", "555-1234");
        bookingSystem.addPatient(newPatient);
        // No direct getter for patient list, so we verify through bookings.
        Appointment testAppointment = new Appointment(102, new Treatment("Stretching"), LocalDateTime.of(2025, 4, 21, 11, 0), newPatient, physio);
        assertTrue(bookingSystem.bookAppointment(testAppointment));
    }

    @Test
    public void testBookAppointmentSuccess() {
        boolean result = bookingSystem.bookAppointment(appointment);
        assertTrue(result);
        assertEquals(1, patient.getAppointments().size());
    }

    @Test
    public void testBookDuplicateAppointmentFails() {
        bookingSystem.bookAppointment(appointment);

        Appointment duplicate = new Appointment(
                102,
                new Treatment("Different Treatment"),
                appointment.getDateTime(), // same time
                new Patient(3, "Alex", "Elsewhere", "888-9999"),
                physio // same physio
        );

        boolean result = bookingSystem.bookAppointment(duplicate);
        assertFalse(result);
    }

    @Test
    public void testCancelAppointment() {
        bookingSystem.bookAppointment(appointment);
        boolean cancelled = bookingSystem.cancelAppointment(appointment);
        assertTrue(cancelled);
        assertEquals("Cancelled", appointment.getStatus());
    }

    @Test
    public void testAttendAppointment() {
        bookingSystem.bookAppointment(appointment);
        boolean attended = bookingSystem.attendAppointment(appointment);
        assertTrue(attended);
        assertEquals("Attended", appointment.getStatus());
    }

    @Test
    public void testCannotAttendCancelledAppointment() {
        bookingSystem.bookAppointment(appointment);
        bookingSystem.cancelAppointment(appointment);
        boolean attended = bookingSystem.attendAppointment(appointment);
        assertFalse(attended);
        assertEquals("Cancelled", appointment.getStatus());
    }
}
