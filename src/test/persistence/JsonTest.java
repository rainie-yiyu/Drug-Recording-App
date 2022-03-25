package persistence;

import model.Category;
import model.Drug;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkDrug(String name, String takentime, Drug drug) {
        assertEquals(name, drug.getName());
        assertEquals(takentime, drug.getTakentime());
    }
}