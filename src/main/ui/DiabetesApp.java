package ui;

import model.BloodSugar;
import model.Drug;
import model.DrugPlan;

import java.util.Scanner;
import java.util.concurrent.BlockingDeque;

public class DiabetesApp {
    private Scanner input;
    private Drug drug1;
    private Drug drug2;
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
        drug1 = new Drug("metafomin","BID");
        drug2 = new Drug("Jentadueto", "TID");
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
            doAddDrug();
        } else if (command.equals("d")) {
            doDeleteDrug();
        } else if (command.equals("r")) {
            doRecordBloodSugar();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    //MODIFIES:this
    //EFFECTS: conducts a add  drug to the plan action.
    private void doAddDrug() {
        String selection;
        System.out.print("Enter the drug you need to take: ");

        selection = input.next();
        selection = selection.toLowerCase();

        drugPlan.addDrug(drug1);
        System.out.print(drugPlan.returnDrugName());







    }

    private void doDeleteDrug() {
        String selection;
        System.out.print("Enter the drug you need to delete: ");

        selection = input.next();
        selection = selection.toLowerCase();

        drugPlan.deleteDrug(drug1);
        System.out.print(drugPlan.returnDrugName());

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
