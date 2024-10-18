package org.example.csc325_gp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 * @author Josh
 */
public class ToolbarController {
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
