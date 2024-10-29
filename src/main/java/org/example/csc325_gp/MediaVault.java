package org.example.csc325_gp;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class MediaVault extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        SceneManager sceneManager = SceneManager.getInstance();
        stage.setResizable(false);
        sceneManager.setPrimaryStage(stage);

        sceneManager.loadScene("home");
        sceneManager.loadScene("history");
        sceneManager.loadScene("item-page");
        sceneManager.loadScene("account-info");
        sceneManager.loadScene("sign-in");
        sceneManager.loadScene("purchases");
        sceneManager.loadScene("splash-screen");
        sceneManager.showScene("home");
    }

    public static void main(String[] args) {
        launch();
    }
}