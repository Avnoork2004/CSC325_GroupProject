package org.example.csc325_gp.controllers;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import org.example.csc325_gp.PersistentData;
import org.example.csc325_gp.SceneManager;
import org.example.csc325_gp.User;

public class SignInController {

    public PasswordField passField;
    public VBox root;
    @FXML
    private Button confirmBtn; // Button to submit form

    @FXML
    private Label validationMessage; // Label to display validation messages

    @FXML
    private TextField emailField; // TextField for Email


    // Regex for validation (checked with regex101)
    private final String nameRegex = "^[a-zA-Z]{2,25}$";
    private final String dobRegex = "^(0[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])/((19|20)\\d\\d)$";
    private final String emailRegex = "^[a-zA-Z0-9._%+-]+@farmingdale.edu$";
    private final String zipRegex = "^[0-9]{5}$";

    private final SceneManager sm = SceneManager.getInstance();

    @FXML
    public void initialize() {
        // Add listeners for each field for focus change (showing & not showing button)
        addFocusListeners();

        // BooleanBinding to check all fields are valid
        BooleanBinding isFormValid = Bindings.createBooleanBinding(() ->
                    !emailField.getText().matches(emailRegex),
                emailField.textProperty(),
                passField.textProperty()
        );

        // Disables "Add" button if a field is not valid
        confirmBtn.disableProperty().bind(isFormValid);
    }

    private void addFocusListeners() {
        emailField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) { // Focus lost ( goes away)
                checkValidity(emailField, emailRegex, "Email");
            }
        });
    }

    // checks if valid input for specific field using regular expression and updates validation message
    private void checkValidity(TextField field, String regex, String fieldName) {
        if (field.getText().matches(regex)) {
            validationMessage.setText("");
        } else {
            validationMessage.setText(fieldName + " is invalid.");
        }
    }

    public void goToRegister(ActionEvent actionEvent) {
        sm.showScene("register");
    }

    public void goToHome(ActionEvent actionEvent) {
        PersistentData inst = PersistentData.getInstance();
        inst.setUser(new User(1, "Wumpus", "I will now do a twirl", "kuczbj@farmingdale.edu"));
        sm.showScene("home");
    }
}

