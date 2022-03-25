package persistence;

import model.Drug;
import model.DrugPlan;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class JsonWriterTest extends JsonTest {
    //NOTE TO CPSC 210 STUDENTS: the strategy in designing tests for the JsonWriter is to
    //write data to a file and then use the reader to read it back in and check that we
    //read in a copy of what was written out.

    @Test
    void testWriterInvalidFile() {
        try {
            DrugPlan drugPlan = new DrugPlan("My drug plan");
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyDrugPlan() {
        try {
            DrugPlan drugPlan  = new DrugPlan("My drug plan");
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyDrugPlan.json");
            writer.open();
            writer.write(drugPlan);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyDrugPlan.json");
            drugPlan = reader.read();
            assertEquals("My drug plan", drugPlan.getName());
            assertEquals(0, drugPlan.length());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralDrugplan() {
        try {
            DrugPlan drugPlan = new DrugPlan("My drug plan");
            drugPlan.addDrug(new Drug("metafomin", "qid"));
            drugPlan.addDrug(new Drug("insulin1", "qid"));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralDrugPlan.json");
            writer.open();
            writer.write(drugPlan);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralDrugPlan.json");
            drugPlan = reader.read();
            assertEquals("My drug plan", drugPlan.getName());
            ArrayList<Drug> drugplan = drugPlan.getDrugPlan();
            assertEquals(2, drugplan.size());
            checkDrug("metafomin", "qid", drugplan.get(0));
            checkDrug("insulin1", "qid", drugplan.get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
