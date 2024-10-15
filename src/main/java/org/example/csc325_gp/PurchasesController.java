package org.example.csc325_gp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class PurchasesController {

    @FXML
    private Hyperlink account;

    @FXML
    private AnchorPane cartPanel;

    @FXML
    private Hyperlink history;

    @FXML
    private AnchorPane receiptPanel;

    @FXML
    private Button rentBtn;

    @FXML
    private TextField searchBar;

    @FXML
    private Button searchButton;

    @FXML
    private Hyperlink shoppingCart;

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
