package ui;

import model.BloodSugar;
import model.Drug;
import model.DrugPlan;

import java.util.Scanner;

public class DiabetesApp {
    private Scanner input;
    private Drug newDrug;
    private Drug deletedDrug;
    private DrugPlan drugPlan;
    private BloodSugar value;
    public static final double MIN_GLYCEMIA = 3.9;
    public static final double MAX_GLYCEMIA = 6.1;


    public DiabetesApp() {
        runDiabetesApp();
    }

    private void runDiabetesApp() {
        boolean keepGoing = true;
        String command = null;

        init();

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }

        System.out.println("\nGoodbye!");
    }

    //MODIFIES: this
    //EFFECTS: initialize the diabetes app.
    public void init() {
        drugPlan = new DrugPlan();
        input = new Scanner(System.in);
        input.useDelimiter("\n");

    }

    public void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\ta -> add drug");
        System.out.println("\td -> delete drug");
        System.out.println("\tr -> record bloodsugar ");
        System.out.println("\tq -> quit");

    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("a")) {
            addDrugCommand();
        } else if (command.equals("d")) {
            deleteDrugCommand();
        } else if (command.equals("r")) {
            doRecordBloodSugar();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    //
    private void addDrugCommand() {
        String addDrugName;
        System.out.print("Enter the drug you need to take: ");

        addDrugName = input.next();
        addDrugName = addDrugName.toLowerCase();
        doAddDrug(addDrugName);
    }

    private void doAddDrug(String command) {
        newDrug = new Drug(command, "");
        drugPlan.addDrug(newDrug);
        printDrugPlan();
    }

    private void printDrugPlan() {
        for (Drug drug : drugPlan.getDrugPlan()) {
            System.out.println(drug.getName());
        }
    }

    //MODIFIES:this
    //EFFECTS: conducts a add  drug to the plan action.
//    private void doAddDrug（String selection) {
////        String selection;
////        System.out.print("Enter the drug you need to take: ");
//
//        newDrug = new Drug("selection","");
//        drugPlan.addDrug(newDrug);
//
//        for (Drug drug: drugPlan.returnDrugName()) {
//            System.out.println(drug.getName());
//        }


    private void deleteDrugCommand() {
        String deleteDrugName;
        System.out.print("Enter the drug you need to delete: ");

        deleteDrugName = input.next();
        deleteDrugName = deleteDrugName.toLowerCase();
        doDeleteDrug(deleteDrugName);
    }

    private void doDeleteDrug(String deleteDrugName) {
        for (Drug drug : drugPlan.getDrugPlan()) {
            if (deleteDrugName.equals(drug.getName())) {
               // deletedDrug = new Drug(deleteDrugName, "");
                drugPlan.deleteDrug(drug);
            }
        }
        System.out.println("No such Drug");

        printDrugPlan();
    }


    private void doRecordBloodSugar() {
        String selection;
        System.out.print("Enter your bloodSugar value: ");


        double value = input.nextDouble();


        if (value < MIN_GLYCEMIA) {
            System.out.println("warning! Too low");
        } else if (value >= MAX_GLYCEMIA) {
            System.out.println("Warning! Too High");
        } else {
            System.out.println("all good!");
        }

    }


}
