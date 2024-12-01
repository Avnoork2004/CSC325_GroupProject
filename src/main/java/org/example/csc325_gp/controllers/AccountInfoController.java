package org.example.csc325_gp.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import org.example.csc325_gp.PersistentData;
import org.example.csc325_gp.User;
import javafx.fxml.Initializable;

public class AccountInfoController {

    @FXML
    private Label accountinfo;

    @FXML
    private Label accountinfotext;

    @FXML
    private AnchorPane tabsaccountinfo;

    @FXML
    private TextField userField, passField, emailField, dobField, zipField;

    @FXML
    private Button editButton, applyButton, cancelButton;

    public void grumble_grumble_I_dont_understand_this(){
        PersistentData inst = PersistentData.getInstance();
        User curUser = inst.getUser();
        userField.setText(curUser.getName());
        passField.setText(curUser.getPassword());
        emailField.setText(curUser.getEmail());
    }
    @FXML
    public void initialize() {
        PersistentData inst = PersistentData.getInstance();
        System.out.println("1: " + inst);
        User curUser = inst.getUser();
        System.out.println("2: " + curUser);
        System.out.println(curUser.getName());
        userField.setText(curUser.getName());
        System.out.println("3");
        passField.setText(curUser.getPassword());
        System.out.println("4");
        emailField.setText(curUser.getEmail());
        System.out.println("5");
    }

    @FXML
    void goToHistory(ActionEvent event) {

    }

    @FXML
    void gotToAccount(ActionEvent event) {

    }

    @FXML
    void gotToShoppingCard(ActionEvent event) {

    }

    @FXML
    void submit(ActionEvent event) {

    }

    @FXML
    void allowEdits(){
        userField.setDisable(false);
        passField.setDisable(false);
        emailField.setDisable(false);
        dobField.setDisable(false);
        zipField.setDisable(false);
        cancelButton.setVisible(true);
        applyButton.setVisible(true);
        cancelButton.setDisable(false);
        applyButton.setDisable(false);
        editButton.setDisable(true);
        editButton.setVisible(false);
    }

    @FXML
    void cancelEdits(){
        userField.setDisable(true);
        passField.setDisable(true);
        emailField.setDisable(true);
        dobField.setDisable(true);
        zipField.setDisable(true);
        cancelButton.setVisible(false);
        applyButton.setVisible(false);
        cancelButton.setDisable(true);
        applyButton.setDisable(true);
        editButton.setVisible(true);
        editButton.setDisable(false);
    }

    @FXML
    void applyEdits(){
        //TO DO: update the backend with the data input here
    }
}