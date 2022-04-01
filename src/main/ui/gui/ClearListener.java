package ui.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClearListener implements ActionListener {
    private DiabetesAppGUI diabetesAppGUI;

    //MODIFIES: constructor;
    public ClearListener(DiabetesAppGUI diabetesAppGUI) {
        this.diabetesAppGUI = diabetesAppGUI;
    }

    //MODIFES: clear all the drugs when press clear button;
    @Override
    public void actionPerformed(ActionEvent e) {
        diabetesAppGUI.defaultListModel.clear();
        diabetesAppGUI.yuDrugPlan.clearDrugPlan();

    }
}
