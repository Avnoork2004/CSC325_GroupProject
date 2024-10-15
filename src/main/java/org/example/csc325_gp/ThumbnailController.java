package org.example.csc325_gp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ThumbnailController {

    @FXML
    private Hyperlink account;

    @FXML
    private Hyperlink history;

    @FXML
    private TextField searchBar;

    @FXML
    private Button searchButton;

    @FXML
    private Hyperlink shoppingCart;

    @FXML
    private Label thumbnail1;

    @FXML
    private Label thumbnail2;

    @FXML
    private Label thumbnail3;

    @FXML
    void goToHistory(ActionEvent event) {
        SceneManager sceneManager = SceneManager.getInstance();
        sceneManager.showScene("history");
    }

    @FXML
    void gotToAccount(ActionEvent event) {
        SceneManager sceneManager = SceneManager.getInstance();
        sceneManager.showScene("account");
    }

    @FXML
    void gotToShoppingCard(ActionEvent event) {
        SceneManager sceneManager = SceneManager.getInstance();
        sceneManager.showScene("purchases");
    }

    @FXML
    void submit(ActionEvent event) {

    }

}
