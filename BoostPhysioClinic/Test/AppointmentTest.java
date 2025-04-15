import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class AppointmentTest {

    private Appointment appointment;
    private Treatment treatment;
    private Patient patient;
    private Physiotherapist physiotherapist;

    @BeforeEach
    void setUp() {
        treatment = new Treatment("Massage Therapy");
        patient = new Patient(1, "John Doe", "123 Main St", "123-456-7890");
        physiotherapist = new Physiotherapist(1, "Dr. Smith", "456 Health St", "555-1234", java.util.List.of("Back Pain"));
        appointment = new Appointment(101, treatment, LocalDateTime.of(2025, 4, 15, 10, 0), patient, physiotherapist);
    }

    @Test
    void testInitialStatusIsScheduled() {
        assertEquals("Scheduled", appointment.getStatus());
    }

    @Test
    void testAttendAppointmentChangesStatusToAttended() {
        boolean result = appointment.attend();
        assertTrue(result);
        assertEquals("Attended", appointment.getStatus());
    }

    @Test
    void testAttendAlreadyCancelledAppointmentFails() {
        appointment.cancel();
        boolean result = appointment.attend();
        assertFalse(result);
        assertEquals("Cancelled", appointment.getStatus());
    }

    @Test
    void testCancelAppointment() {
        boolean result = appointment.cancel();
        assertTrue(result);
        assertEquals("Cancelled", appointment.getStatus());
    }

    @Test
    void testDoubleCancelReturnsFalse() {
        appointment.cancel();
        boolean secondCancel = appointment.cancel();
        assertFalse(secondCancel);
    }

    @Test
    void testIsAvailableReturnsTrueForScheduled() {
        assertTrue(appointment.isAvailable());
    }

    @Test
    void testIsAvailableReturnsFalseForCancelled() {
        appointment.cancel();
        assertFalse(appointment.isAvailable());
    }

    @Test
    void testGetDetailsContainsCorrectInfo() {
        String details = appointment.getDetails();
        assertTrue(details.contains("Appointment ID: 101"));
        assertTrue(details.contains("Massage Therapy"));
        assertTrue(details.contains("John Doe"));
        assertTrue(details.contains("Dr. Smith"));
    }
}
