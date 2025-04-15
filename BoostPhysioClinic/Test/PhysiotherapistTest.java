import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PhysiotherapistTest {

    @Test
    public void testPhysiotherapistInitialization() {
        Physiotherapist physio = new Physiotherapist(
                1,
                "Dr. Alice",
                "123 Therapy Rd",
                "555-6789",
                List.of("Neck Pain", "Sports Injuries")
        );

        assertNotNull(physio);
        assertEquals("Dr. Alice", physio.getName());
    }
}
