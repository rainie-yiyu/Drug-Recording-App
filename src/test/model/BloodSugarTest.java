package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BloodSugarTest {
    private BloodSugar newBloodSugar;

    @BeforeEach
    void runBefore() {
        newBloodSugar = new BloodSugar(4.2);
    }

    @Test
    void testConstructor() {
        assertEquals(4.2, newBloodSugar.getValue());
    }

    @Test
    void testValueWarning() {
        assertEquals("warning",newBloodSugar.valueWarning(10));
        assertEquals("all good",newBloodSugar.valueWarning(4.2));
        assertEquals("warning",newBloodSugar.valueWarning(1));
    }
}
