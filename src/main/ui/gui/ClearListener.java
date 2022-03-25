package ui.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClearListener implements ActionListener {
    private DiabetesAppGUI diabetesAppGUI;

    public ClearListener(DiabetesAppGUI diabetesAppGUI) {
        this.diabetesAppGUI = diabetesAppGUI;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        diabetesAppGUI.defaultListModel.clear();
        diabetesAppGUI.yuDrugPlan.clearDrugPlan();

    }
}
