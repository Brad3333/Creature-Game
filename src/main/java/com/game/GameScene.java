package com.game;

import com.game.scene.background.BackgroundLoader;
import com.game.scene.content.screen.ScreenDefinition;
import com.game.scene.engine.SceneManager;

import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;

public class GameScene extends Pane {

    private final Canvas canvas;
    private final SceneManager sceneManager;
    private final GameLoop loop;

    public GameScene() {

        // Visual brain of our game
        BackgroundLoader loader = new BackgroundLoader();
        this.sceneManager = new SceneManager(loader, ScreenDefinition.START);

        canvas = new Canvas(UGV.SCREEN_WIDTH, UGV.SCREEN_HEIGHT);

        // This sends all mouse clicks into our SceneManager
        canvas.setOnMouseClicked(event -> sceneManager.handleMouseClick(event.getX(), event.getY()));

        this.getChildren().add(canvas);

        // Game timing system
        loop = new GameLoop(canvas.getGraphicsContext2D(), sceneManager);
        loop.start();
    }

}