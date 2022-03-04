package persistence;

import model.BloodSugar;
import model.Category;
import model.Drug;
import model.DrugPlan;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

// Represents a reader that reads DrugPlan from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads DrugPlan from file and returns it;
    // throws IOException if an error occurs reading data from file
    public DrugPlan read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseDrugPlan(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses workroom from JSON object and returns it
    private DrugPlan parseDrugPlan(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        DrugPlan drugPlan = new DrugPlan(name);
        addDrugs(drugPlan, jsonObject);
        return drugPlan;
    }

    // MODIFIES: drugplan
    // EFFECTS: parses drugs from JSON object and adds them to drugplan
    private void addDrugs(DrugPlan drugPlan, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("drugplan");
        for (Object json : jsonArray) {
            JSONObject nextThingy = (JSONObject) json;
            addDrug(drugPlan, nextThingy);
        }
    }

    // MODIFIES: drugplan
    // EFFECTS: parses drug from JSON object and adds it to drugplan
    private void addDrug(DrugPlan drugPlan, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        Category category = Category.valueOf(jsonObject.getString("category"));
        Drug drug = new Drug(name, category);
        drugPlan.addDrug(drug);
    }
}

