package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;

//Represent a druglist that the patient need to take everyday.
public class DrugPlan implements Writable {
    private String name;
    private ArrayList<Drug> drugPlan;

    //EFFECTS: constructs drugplan with a name and empty list of drug
    public DrugPlan(String name) {
        this.name = name;
        drugPlan = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    //MODIFIES: this
    //EFFECTS: takes a Drug as an argument and, adds it to the DrupPlan.
    public void addDrug(Drug drug) {
        drugPlan.add(drug);
    }

    //REQUIRES: the drugplan is not empty.
    //MODIFIES: this
    //EFFECTS: takes a Drug as an argument and delete it if the patients don't need to take it anymore;
    public void deleteDrug(Drug drug) {
        drugPlan.remove(drug);
    }


    //EFFECTS:get the number of how many kinds of drug are in the drug plan.
    public int length() {
        return drugPlan.size();
    }

    //EFFECTS: input the index and get the drug out of the drupplan.
    public Drug getIndexDrug(int d) {
        return drugPlan.get(d);
    }


    public void clearDrugPlan() {
        drugPlan.clear();
    }

    public Drug getIndex(int i) {
        return drugPlan.get(i);
    }


    //EFFECTS: return all the drug name in the drug plan.
    public ArrayList<Drug> getDrugPlan() {
        return drugPlan;
    }

    public ArrayList<String> viewDrugs() {
        ArrayList<String> drugString = new ArrayList<>();
        int m = this. length();
        for (int i = 0; i < m; i++) {
            Drug d = this.getIndex(i);
            drugString.add(d.toString());
        }
        return drugString;
    }


    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("drugplan", drugsToJson());
        return json;
    }

    // EFFECTS: returns drugs in this DrugPlan as a JSON array
    private JSONArray drugsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Drug d : drugPlan) {
            jsonArray.put(d.toJson());
        }

        return jsonArray;
    }





}

