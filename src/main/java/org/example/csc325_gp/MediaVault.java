package org.example.csc325_gp;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class MediaVault extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        SceneManager sceneManager = SceneManager.getInstance();
        stage.setResizable(true);
        sceneManager.setPrimaryStage(stage);

        sceneManager.showScene("sign-in",860, 680);
    }

    public static void main(String[] args) {
        launch();
    }
}