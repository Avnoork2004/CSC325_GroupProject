package org.example.csc325_gp;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class MediaVault extends Application {

    private String START_SCREEN = "account-info";
    @Override
    public void start(Stage stage) throws IOException {
        SceneManager sceneManager = SceneManager.getInstance();
        stage.setResizable(true);
        sceneManager.setPrimaryStage(stage);
        if (!(START_SCREEN == "sign-in")){
            PersistentData inst = PersistentData.getInstance();
            inst.setUser(new User(1, "Example Name", "Example Password", "Example Email"));
        }
        sceneManager.showScene(START_SCREEN,860, 680);
    }

    public static void main(String[] args) {
        launch();
    }
}