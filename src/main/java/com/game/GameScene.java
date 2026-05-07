package com.game;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;

public class GameScene extends Pane {

    private Canvas canvas;
    private GraphicsContext g;

    private GameLoop loop;
    private GameRenderer renderer;

    public GameScene() {

        canvas = new Canvas(800, 600);
        g = canvas.getGraphicsContext2D();

        this.getChildren().add(canvas);

        renderer = new GameRenderer();
        loop = new GameLoop(g, renderer);

        loop.start();
    }
}