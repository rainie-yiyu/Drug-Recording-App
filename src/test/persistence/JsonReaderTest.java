package persistence;

import model.Category;
import model.Drug;
import model.DrugPlan;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            DrugPlan drugPlan = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyWorkRoom() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyDrugPlan.json");
        try {
            DrugPlan drugPlan = reader.read();
            assertEquals("My drug plan", drugPlan.getName());
            assertEquals(0, drugPlan.length());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralWorkRoom() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralDrugPlan.json");
        try {
            DrugPlan drugPlan = reader.read();
            assertEquals("My drug plan", drugPlan.getName());
            ArrayList<Drug> drugplan = drugPlan.getDrugPlan();
            assertEquals(2, drugplan.size());
            checkDrug("metafomin", Category.METFORMIN, drugplan.get(0));
            checkDrug("insulin1", Category.INSULIN, drugplan.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
