package com.game;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) {

        GameScene gameScene = new GameScene();

        Scene scene = new Scene(gameScene, 800, 600);

        stage.setTitle("Creature Game");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

/* ---------------- Scene Manager ---------------- */

class SceneManager {
    private static Stage stage;

    public static void init(Stage s) {
        stage = s;
    }

    public static void setScene(Scene scene) {
        stage.setScene(scene);
    }
}

/* ---------------- Start Scene ---------------- */

class StartScene {

    public Scene getScene() {
        VBox root = new VBox();
        root.getChildren().add(new Label("Creature Game"));

        return new Scene(root, 800, 600);
    }
}