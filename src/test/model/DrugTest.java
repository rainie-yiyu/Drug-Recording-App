package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DrugTest {
    Drug d;

    @Test
    void testConstructor() {
        Drug d = new Drug("metformin",  "qid");
        assertEquals("metformin", d.getName());
       // assertEquals(Category.METFORMIN, d.getCategory());
    }

    @Test
    void testToString() {
        Drug d = new Drug("metformin", "qid");
        assertEquals("METFORMIN: metformin",d.toString());
    }


}




