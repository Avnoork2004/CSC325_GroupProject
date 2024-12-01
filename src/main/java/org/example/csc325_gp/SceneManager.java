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

    private int windowWidth;
    private int windowHeight;

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

    /**
     * Used to change the scene.
     * @param sceneName name of the scene to show.
     * @param width use to set window width
     * @param height use to set window height
     */
    public void showScene(String sceneName, int width, int height) {
        if (!scenes.containsKey(sceneName)) if (!loadScene(sceneName)) return;

        windowWidth = width;
        windowHeight = height;

        Scene scene = scenes.get(sceneName);
        if (scene != null) {
            primaryStage.setScene(scene);
            if (width > 0) {
                primaryStage.setWidth(width);
                primaryStage.setHeight(height);
            }
            else {
                primaryStage.setWidth(windowWidth);
                primaryStage.setHeight(windowHeight);
            }
            primaryStage.show();
        } else {
            System.out.println("Scene not found: " + sceneName);
        }
    }

    /**
     * Used to change the scene.
     * @param sceneName name of the scene to show.
     */
    public void showScene(String sceneName) {
        showScene(sceneName, -1, -1);
    }
}
