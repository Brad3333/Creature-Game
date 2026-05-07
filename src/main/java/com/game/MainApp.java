package com.game;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) {
        
        GameScene gameScene = new GameScene();

        Scene scene = new Scene(gameScene, UGV.SCREEN_WIDTH, UGV.SCREEN_HEIGHT);

        stage.setTitle(UGV.GAME_TITLE);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        stage.centerOnScreen();
    }

    public static void main(String[] args) {
        launch(args);
    }
}