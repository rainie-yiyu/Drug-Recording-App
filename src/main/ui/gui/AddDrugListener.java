package ui.gui;

import model.Drug;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDrugListener implements ActionListener, DocumentListener {
    private boolean buttonEnabled = false;

    private DiabetesAppGUI drugPlanGUI;
    private JButton addButton;


    //MODIFIES: constructor;
    public AddDrugListener(DiabetesAppGUI drugPlanGUI, JButton addButton) {
        this.drugPlanGUI = drugPlanGUI;
        this.addButton = addButton;
    }


    //MODIFEIS: do add drug to the list;
    @Override
    public void actionPerformed(ActionEvent e) {
        String drugNameText = drugPlanGUI.drugName.getText();
        String takeTimeText = drugPlanGUI.takeTime.getText();
        int i = drugPlanGUI.myDrugPlanList.getSelectedIndex();

        if (i == -1) {
            i = 0;
        } else {
            i++;
        }
        Drug drug = new Drug(drugNameText, takeTimeText);
        drugPlanGUI.yuDrugPlan.addDrug(drug);
        drugPlanGUI.defaultListModel.addElement(drug.toString());

        drugPlanGUI.drugName.setText("");
        drugPlanGUI.takeTime.setText("");
        drugPlanGUI.myDrugPlanList.setSelectedIndex(i);
        drugPlanGUI.myDrugPlanList.ensureIndexIsVisible(i);


    }

    //MODIFIES: enalble the button when is enabled;
    @Override
    public void insertUpdate(DocumentEvent e) {
        enableButton();
    }

    //MODIFES: when there are nothing;
    @Override
    public void removeUpdate(DocumentEvent e) {
        handleEmptyField(e);

    }


    //MODIFES: change the button when it's not enabled;
    @Override
    public void changedUpdate(DocumentEvent e) {
        if (!handleEmptyField(e)) {
            enableButton();
        }

    }

    //MODIFES: set the button that can be choose;
    private void enableButton() {
        if (!buttonEnabled) {
            addButton.setEnabled(true);
        }
    }

    //MODIFES: when there is empty field in the textfield, do nothing;
    private boolean handleEmptyField(DocumentEvent e) {
        if (e.getDocument().getLength() <= 0) {
            addButton.setEnabled(false);
            buttonEnabled = false;
            return true;
        }
        return false;
    }


    public DiabetesAppGUI getDrugPlanGUI() {
        return drugPlanGUI;
    }

    //MODIFES: set the GUI be the GUI that we choose;
    public void setGUI(DiabetesAppGUI drugPlanGUI) {
        if (getDrugPlanGUI() != drugPlanGUI) {
            this.drugPlanGUI = drugPlanGUI;
            drugPlanGUI.addListener(this);
        }
    }
}
