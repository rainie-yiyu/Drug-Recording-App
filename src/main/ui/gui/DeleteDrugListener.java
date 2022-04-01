package ui.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteDrugListener implements ActionListener {
    private DiabetesAppGUI diabetesAppGUI;

    public DeleteDrugListener(DiabetesAppGUI diabetesAppGUI) {
        this.diabetesAppGUI = diabetesAppGUI;
    }

    //MODIFES: delete the drug in the list that we have choose;
    @Override
    public void actionPerformed(ActionEvent e) {
        int s = diabetesAppGUI.defaultListModel.getSize();
        int i = diabetesAppGUI.myDrugPlanList.getSelectedIndex();
        diabetesAppGUI.yuDrugPlan.deleteDrug(diabetesAppGUI.yuDrugPlan.getIndex(i));
        diabetesAppGUI.defaultListModel.remove(i);

        if (s == 0) {
            diabetesAppGUI.deleteButton.setEnabled(false);
        } else {
            diabetesAppGUI.deleteButton.setEnabled(true);
            if (i == s) {
                i--;
            }
            diabetesAppGUI.myDrugPlanList.setSelectedIndex(i);
            diabetesAppGUI.myDrugPlanList.ensureIndexIsVisible(i);
        }

    }
}
