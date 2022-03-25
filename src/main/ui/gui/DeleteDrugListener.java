package ui.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteDrugListener implements ActionListener {
    private DiabetesAppGUI diabetesAppGUI;

    public DeleteDrugListener(DiabetesAppGUI diabetesAppGUI) {
        this.diabetesAppGUI = diabetesAppGUI;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int s = diabetesAppGUI.defaultListModel.getSize();
        int i = diabetesAppGUI.myDrugPlan.getSelectedIndex();

        diabetesAppGUI.yuDrugPlan.deleteDrug(diabetesAppGUI.yuDrugPlan.getIndex(i));
        diabetesAppGUI.defaultListModel.remove(i);

        if (s == 0) {
            diabetesAppGUI.deleteButton.setEnabled(false);
        } else {
            diabetesAppGUI.deleteButton.setEnabled(true);
            if (i == s) {
                i--;
            }
            diabetesAppGUI.myDrugPlan.setSelectedIndex(i);
            diabetesAppGUI.myDrugPlan.ensureIndexIsVisible(i);
        }

    }
}
