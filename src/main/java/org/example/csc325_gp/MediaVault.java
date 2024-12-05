package org.example.csc325_gp;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class MediaVault extends Application {
    /**
     *
     * @param stage the primary stage for this application, onto which
     * the application scene can be set.
     * Applications may create other stages, if needed, but they will not be
     * primary stages.
     * @throws IOException
     */
    @Override
    public void start(Stage stage) throws IOException {
        SceneManager sceneManager = SceneManager.getInstance();
        stage.setResizable(true);
        stage.setTitle("Media Vault");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("images/MediaVault3.png")));
        sceneManager.setPrimaryStage(stage);

        sceneManager.showScene("sign-in",860, 680);
    }

    public static void main(String[] args) {
        launch();
    }
}