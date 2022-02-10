package model;

//Represents the bloodSugar of a patient record and the unit is mol/l
public class BloodSugar {
    private double bloodSugar;
    public static final double MIN_GLYCEMIA = 3.9;
    public static final double MAX_GLYCEMIA = 6.1;
    //   public static final double MAX_GLYCEMIA_AFTERMEAL = 11.1;

    //represent the blood sugar value of a patient.
    public BloodSugar(double value) {
        bloodSugar = value;
    }


    //EFFECTS: takes no arguement and set the blood sugar value
    public double getValue() {
        return bloodSugar;
    }

    public double setValue(double bloodSugar) {
        return this.bloodSugar = bloodSugar;
    }

    //REQUIRES: the blood sugar value can not be negative.
    //EFFECTS : takes blood sugar value as an arguement and if the value is out of
    //the range return "warning", if not return "all good".
    public String valueWarning(double bloodSugar) {
        if (bloodSugar < MIN_GLYCEMIA || bloodSugar > MAX_GLYCEMIA) {
            return "warning";
        } else {
            return "all good";
        }
    }
}



