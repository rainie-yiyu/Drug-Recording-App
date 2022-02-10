package model;

//Represent the medicine that Diabetes Patient need to take
//with its name, Drug instruction and status(take or not).
public class Drug {
    private String name;
    private String instruction;
    private boolean isTaken;

    // EFFECTS: Drug that with its name and instruction and has not been taken.
    public Drug(String name, String instruction) {
        this.name = name;
        this.instruction = instruction;
        isTaken = false;
    }

    // EFFECTS: returns name
    public String getName() {
        return name;
    }

    // EFFECTS: returns instruction
    public String getInstruction() {
        return instruction;
    }

    // EFFECTS: returns true if case is taken, false otherwise
    public boolean isTaken() {
        return isTaken;
    }

    // MODIFIES: this
    // EFFECTS: take the medicine and isTaken return true.
    public void setTaken() {
        isTaken = true;
    }


}
