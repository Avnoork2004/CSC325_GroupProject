package org.example.csc325_gp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        SceneManager sceneManager = SceneManager.getInstance();
        stage.setResizable(false);
        sceneManager.setPrimaryStage(stage);

        sceneManager.loadScene("home", "home.fxml");
        sceneManager.loadScene("history", "history.fxml");
        sceneManager.loadScene("items", "item-page.fxml");
        sceneManager.loadScene("account", "account-info.fxml");
        sceneManager.loadScene("signIn", "sign-in.fxml");
        sceneManager.loadScene("purchases", "purchases.fxml");
        sceneManager.showScene("home");
    }

    public static void main(String[] args) {
        launch();
    }
}