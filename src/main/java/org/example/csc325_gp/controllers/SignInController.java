package org.example.csc325_gp.controllers;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class SignInController {

    @FXML
    private Button addButton; // Button to submit form

    @FXML
    private TextField dobField; // TextField for Date of Birth

    @FXML
    private TextField emailField; // TextField for Email

    @FXML
    private TextField firstNameField; // TextField for First Name

    @FXML
    private TextField lastNameField; // TextField for Last Name

    @FXML
    private Label validationMessage; // Label to display validation messages

    @FXML
    private TextField zipField; // TextField for Zip Code

    // Regex for validation (checked with regex101)
    private final String nameRegex = "^[a-zA-Z]{2,25}$";
    private final String dobRegex = "^(0[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])/((19|20)\\d\\d)$";
    private final String emailRegex = "^[a-zA-Z0-9._%+-]+@farmingdale.edu$";
    private final String zipRegex = "^[0-9]{5}$";

    @FXML
    public void initialize() {
        // Add listeners for each field for focus change (showing & not showing button)
        addFocusListeners();

        // BooleanBinding to check all fields are valid
        BooleanBinding isFormValid = Bindings.createBooleanBinding(() ->
                        !firstNameField.getText().matches(nameRegex) ||
                                !lastNameField.getText().matches(nameRegex) ||
                                !emailField.getText().matches(emailRegex) ||
                                !dobField.getText().matches(dobRegex) ||
                                !zipField.getText().matches(zipRegex),
                firstNameField.textProperty(),
                lastNameField.textProperty(),
                emailField.textProperty(),
                dobField.textProperty(),
                zipField.textProperty()
        );

        // Disables "Add" button if a field is not valid
        addButton.disableProperty().bind(isFormValid);
        addButton.setOnAction(this::onHelloButtonClick);
    }

    private void addFocusListeners() {
        firstNameField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) { // Focus lost ( goes away)
                checkValidity(firstNameField, nameRegex, "First Name");
            }
        });

        lastNameField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) { // Focus lost ( goes away)
                checkValidity(lastNameField, nameRegex, "Last Name");
            }
        });

        emailField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) { // Focus lost ( goes away)
                checkValidity(emailField, emailRegex, "Email");
            }
        });

        dobField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) { // Focus lost ( goes away)
                checkValidity(dobField, dobRegex, "Date of Birth");
            }
        });

        zipField.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) { // Focus lost ( goes away)
                checkValidity(zipField, zipRegex, "Zip Code");
            }
        });
    }

    // checks if valid input for specific field using regular expression and updates validation message
    private void checkValidity(TextField field, String regex, String fieldName) {
        if (field.getText().matches(regex)) {
            validationMessage.setText(fieldName + " is valid.");
        } else {
            validationMessage.setText(fieldName + " is invalid.");
        }
    }

    @FXML
    private void onHelloButtonClick(ActionEvent event) {
        if (!addButton.isDisabled()) {
            // validationMessage.setText("Registration Successful!"); //  success message moved to new gui
            loadAnotherView(); // Calls method to load new view fxml
        } else {
            validationMessage.setText("Please correct the invalid fields."); // Displays error if form is invalid
        }
    }



    /**
     * Loads a new view by initializing another FXML file and displaying it in a new stage.
     * The method  closes the current window after opening a new one.
     *
     * @throws IOException if there's an error loading the FXML file.
     */

    private void loadAnotherView() {
        try {
            // Loads new FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/csc325_gp/fxml/home.fxml"));
            Parent anotherView = loader.load();

            // Creates new stage and sets scene for new view
            Stage stage = new Stage();
            stage.setScene(new Scene(anotherView, 600, 400));
            stage.setTitle("Home");
            stage.show();

            // Closes the current window after opening the new one (another-view)
            ((Stage) addButton.getScene().getWindow()).close();
        } catch (IOException e) {
            e.printStackTrace(); // error handling during loading
        }
    }
}

