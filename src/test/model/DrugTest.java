package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DrugTest {
    Drug d;

    @Test
    void testConstructor() {
        Drug d = new Drug("metformin", "TID");
        assertEquals("metformin", d.getName());
        assertEquals("TID",d.getInstruction());
    }

    @Test
    void testSetTaken() {
        Drug d = new Drug("metformin", "three times a day");
        d.setTaken();
        assertTrue(d.isTaken());
    }



}