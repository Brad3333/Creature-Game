package com.game;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(@SuppressWarnings("exports") Stage stage) {

        // Main game canvas container (all rendering goes through this)
        GameScene gameScene = new GameScene();

        Scene scene = new Scene(gameScene, UGV.SCREEN_WIDTH, UGV.SCREEN_HEIGHT);

        stage.setTitle(UGV.GAME_TITLE);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        stage.centerOnScreen();
    }

    /**
     * Entry point for the JavaFX application.
     * Launches the JavaFX lifecycle and calls start().
     */
    public static void main(String[] args) {
        launch(args);
    }
}