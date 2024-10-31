package org.example.csc325_gp;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.HashMap;

import java.io.IOException;

public class SceneManager {
    private static SceneManager instance;
    private Stage primaryStage;

    private HashMap<String, Scene> scenes = new HashMap<>();
    public static SceneManager getInstance(){
        if (instance == null){
            instance = new SceneManager();
        }
        return instance;
    }
    public void setPrimaryStage(Stage stage) {
        this.primaryStage = stage;
    }

    public boolean loadScene(String fxmlSceneName) {
        try {
            // Load the FXML file and create a Scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/"+fxmlSceneName+".fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            // Store the scene by name
            scenes.put(fxmlSceneName, scene);
            return true;
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Failed to load scene "+fxmlSceneName);
            return false;
        }
    }

    public void showScene(String sceneName) {
        if (!scenes.containsKey(sceneName)) if (!loadScene(sceneName)) return;

        Scene scene = scenes.get(sceneName);
        if (scene != null) {
            primaryStage.setScene(scene);
            primaryStage.show();
        } else {
            System.out.println("Scene not found: " + sceneName);
        }
    }
}
