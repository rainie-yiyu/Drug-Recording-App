package ui.console;

import model.Category;
import model.Drug;
import model.DrugPlan;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

//Represents the diabetes application
public class DiabetesApp {
    private static final String JSON_STORE = "./data/drugplan.json";
    private Scanner input;
    private Drug newDrug;
    private DrugPlan drugPlan;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    public static final double MIN_GLYCEMIA = 3.9;
    public static final double MAX_GLYCEMIA = 6.1;

    //EFFECTS: constructs drugplan and runs application
    public DiabetesApp() throws FileNotFoundException {
        input = new Scanner(System.in);
        drugPlan = new DrugPlan();
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        runDiabetesApp();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runDiabetesApp() {
        boolean keepGoing = true;
        String command = null;
        input = new Scanner(System.in);

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


    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\ta -> add drug");
        System.out.println("\td -> delete drug");
        System.out.println("\tp -> print drugplan");
        System.out.println("\tt -> test bloodsugar");
        System.out.println("\ts -> save work room to file");
        System.out.println("\tl -> load work room from file");
        System.out.println("\tq -> quit");
    }

    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("a")) {
            addDrugCommand();
        } else if (command.equals("d")) {
            deleteDrugCommand();
        } else if (command.equals("t")) {
            doRecordBloodSugar();
        } else if (command.equals("p")) {
            printDrugPlan();
        } else if (command.equals("s")) {
            saveDrugPlan();
        } else if (command.equals("l")) {
            loadDrugPlan();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    // MODIFIES: this
    // EFFECTS: prompt user for name and category of thingy and adds to drugplan
    private void addDrugCommand() {
        Category category = readCategory();
        System.out.println("Please enter name of drug: ");
        String name = input.next();
        drugPlan.addDrug(new Drug(name,toString()));
    }

    // EFFECTS: prompts user to select category and returns it
    private Category readCategory() {
        System.out.println("Please select a category for your drug");

        int menuLabel = 1;
        for (Category c : Category.values()) {
            System.out.println(menuLabel + ": " + c);
            menuLabel++;
        }

        int menuSelection = input.nextInt();
        return Category.values()[menuSelection - 1];
    }


    // EFFECTS: prints all the drugs in workroom to the console
    private void printDrugPlan() {
        ArrayList<Drug> drugplan = drugPlan.getDrugPlan();

        for (Drug d : drugplan) {
            System.out.println(d);
        }
    }



    //EFFECTS: process deleteDrug command.
    private void deleteDrugCommand() {
        String deleteDrugName;
        System.out.print("Enter the drug you need to delete: ");

        deleteDrugName = input.next();
        deleteDrugName = deleteDrugName.toLowerCase();
        doDeleteDrug(deleteDrugName);
    }

    //EFFECTS:
    private void doDeleteDrug(String deleteDrugName) {
        for (Drug drug : drugPlan.getDrugPlan()) {
            if (deleteDrugName.equals(drug.getName())) {
               // deletedDrug = new Drug(deleteDrugName, "");
                drugPlan.deleteDrug(drug);
            } else {
                System.out.println("No such Drug");
            }
        }
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

    // EFFECTS: saves the workroom to file
    private void saveDrugPlan() {
        try {
            jsonWriter.open();
            jsonWriter.write(drugPlan);
            jsonWriter.close();
            System.out.println("Saved to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads workroom from file
    private void loadDrugPlan() {
        try {
            drugPlan = jsonReader.read();
            System.out.println("Loaded from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }


}
