package ui;

import model.BloodSugar;
import model.Drug;
import model.DrugPlan;

import java.util.Scanner;

public class DiabetesApp {
    private Scanner input;
    private Drug drug;
    private DrugPlan drugPlan;
    private BloodSugar bloodSugar;

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
        DrugPlan drugplan = new DrugPlan();
        Drug drug1 = new Drug("metafomin","BID");
        Drug drug2 = new Drug("Jentadueto", "TID");
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

        selection = input.nextLine();
        selection = selection.toLowerCase();




    }

    private void doDeleteDrug() {
    }

    private void doRecordBloodSugar() {

    }
}
