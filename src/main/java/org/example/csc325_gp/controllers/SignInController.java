package org.example.csc325_gp.controllers;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import org.example.csc325_gp.User;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class SignInController {

    private static final String USER_DATA_FILE = "users.dat";
    private Map<String, User> userDatabase = new HashMap<>();

    @FXML
    private PasswordField SignInPassField;

    @FXML
    private PasswordField confirmPassField;

    @FXML
    private Button loginBtn;

    @FXML
    private Button registerBtn;

    @FXML
    private PasswordField registerPassField;

    @FXML
    private TextField registerUserField;

    @FXML
    private AnchorPane signInPassField;

    @FXML
    private TextField signInUserField;


    public void initialize() {
        loadUserData();
    }

    @FXML
    void submitLogin(ActionEvent event) {
        String username = signInUserField.getText();
        String password = SignInPassField.getText();

        User user = userDatabase.get(username);
        if (user != null && user.getPassword().equals(password)) {
            showAlert(Alert.AlertType.INFORMATION, "Login Successful", "Welcome, " + user.getName() + "!");
        } else {
            showAlert(Alert.AlertType.ERROR, "Login Failed", "Invalid username or password.");
        }
    }

    @FXML
    void submitRegistration(ActionEvent event) {
        String username = registerUserField.getText();
        String password = registerPassField.getText();
        String confirmPassword = confirmPassField.getText();

        if (password.equals(confirmPassword)) {
            if (userDatabase.containsKey(username)) {
                showAlert(Alert.AlertType.ERROR, "Registration Failed", "Username already exists.");
            } else {
                User newUser = new User();
                newUser.setUserID(generateUniqueUserID());
                newUser.setName(username);
                newUser.setEmail(username + "@example.com");
                newUser.setPassword(password);
                newUser.setProfilePicture("");
                newUser.setCurrentlyRentedItems(new ArrayList<>());

                userDatabase.put(username, newUser);
                saveUserData();
                showAlert(Alert.AlertType.INFORMATION, "Registration Successful", "Account created for " + username);
            }
        } else {
            showAlert(Alert.AlertType.ERROR, "Registration Failed", "Passwords do not match.");
        }
    }


    private void loadUserData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(USER_DATA_FILE))) {
            userDatabase = (Map<String, User>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    private void saveUserData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(USER_DATA_FILE))) {
            oos.writeObject(userDatabase);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private int generateUniqueUserID() {
        return userDatabase.size() + 1;

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
