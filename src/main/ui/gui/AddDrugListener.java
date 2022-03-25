package ui.gui;

import model.Category;
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

    public AddDrugListener(DiabetesAppGUI drugPlanGUI, JButton addButton) {
        this.drugPlanGUI = drugPlanGUI;
        this.addButton = addButton;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String drugNameText = drugPlanGUI.drugName.getText();
        String takeTimeText = drugPlanGUI.takeTime.getText();
        int i = drugPlanGUI.myDrugPlan.getSelectedIndex();

        if (i == -1) {
            i = 0;
        } else {
            i++;
        }
        Drug drug = new Drug(drugNameText, takeTimeText);
        drugPlanGUI.yuDrugPlan.addDrug(drug);
        drugPlanGUI.defaultListModel.addElement(drug.toString());

        drugPlanGUI.drugName.requestFocusInWindow();
        drugPlanGUI.takeTime.requestFocusInWindow();
        drugPlanGUI.drugName.setText("");
        drugPlanGUI.takeTime.setText("");
        drugPlanGUI.myDrugPlan.setSelectedIndex(i);
        drugPlanGUI.myDrugPlan.ensureIndexIsVisible(i);


    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        enableButton();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        handleEmptyField(e);

    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        if (!handleEmptyField(e)) {
            enableButton();
        }

    }

    private void enableButton() {
        if (!buttonEnabled) {
            addButton.setEnabled(true);
        }
    }

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

    public void setGUI(DiabetesAppGUI drugPlanGUI) {
        if (getDrugPlanGUI() != drugPlanGUI) {
            this.drugPlanGUI = drugPlanGUI;
            drugPlanGUI.addListener(this);
        }
    }
}
