package org.example.csc325_gp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {

    @FXML
    private Hyperlink account;

    @FXML
    private Hyperlink history;

    @FXML
    private ScrollPane moviePanel;

    @FXML
    private ScrollPane musicPanel;

    @FXML
    private TextField searchBar;

    @FXML
    private Button searchButton;

    @FXML
    private Hyperlink shoppingCart;

    @FXML
    private ScrollPane videoGamesPanel;

    @FXML
    void goToHistory(ActionEvent event){
        SceneManager sceneManager = SceneManager.getInstance();
        sceneManager.showScene("history");
    }

    @FXML
    void gotToAccount(ActionEvent event) {
        SceneManager sceneManager = SceneManager.getInstance();
        sceneManager.showScene("account");
    }

    @FXML
    void gotToShoppingCart(ActionEvent event) {
        SceneManager sceneManager = SceneManager.getInstance();
        sceneManager.showScene("purchases");
    }

    @FXML
    void submit(ActionEvent event) {

    }

}
