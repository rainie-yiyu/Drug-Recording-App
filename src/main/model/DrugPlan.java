package model;

import java.util.ArrayList;

//Represent a druglist that the patient need to take everyday.
public class DrugPlan {
    private ArrayList<Drug> drugPlan;

    //the user's drugplan with all the drug one need to take.
    public DrugPlan() {
        drugPlan = new ArrayList<>();
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
    //REQUIRES: the drugPlan is not empty.
    //EFFECTS: takes no argument,if there is one drug in the drupplan that has not been taken,
    // return the drugName.If not, return "ALL DOWN".
    public String remindDrug() {
        for (Drug d : drugPlan) {
            if (! (d.isTaken())) {
                return d.getName();
            }
        }
        return "All DOWN";
    }

    public int length() {
        return drugPlan.size();
    }

    public Drug getDrugPlan(int d) {
        return drugPlan.get(d);
    }





}
