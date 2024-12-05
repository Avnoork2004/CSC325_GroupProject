package org.example.csc325_gp.controllers;

import javafx.fxml.Initializable;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ResourceBundle;

public class MediaItemCon implements Initializable {
    public ProgressBar ratingBar;
    public ImageView starMask;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ratingBar.setClip(new ImageView(starMask.getImage()));
    }
}
