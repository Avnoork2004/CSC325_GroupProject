package org.example.csc325_gp.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.example.csc325_gp.SceneManager;

/**
 * @author Josh
 */
public class ToolbarController {

    @FXML
    private Button account;
    @FXML
    private Button shoppingCart;
    @FXML
    private Button history;
    @FXML
    private TextField searchBar;
    @FXML
    private Button searchButton;

    @FXML
    void goToHome(MouseEvent event){
        SceneManager sceneManager = SceneManager.getInstance();
        sceneManager.showScene("home");
    }

    @FXML
    void goToHistory(ActionEvent event){
        SceneManager sceneManager = SceneManager.getInstance();
        sceneManager.showScene("history");
    }

    @FXML
    void gotToAccount(ActionEvent event) {
        SceneManager sceneManager = SceneManager.getInstance();
        sceneManager.showScene("account-info");
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
