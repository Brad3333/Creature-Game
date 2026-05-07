package com.game;

import com.game.gui.ScreenLoader;
import com.game.gui.ScreenManager;
import com.game.gui.screens.ScreenType;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.input.MouseEvent;

public class GameScene extends Pane {

    private Canvas canvas;
    private GraphicsContext g;

    
    public static ScreenLoader loader = new ScreenLoader();
    public static ScreenManager manager = new ScreenManager(loader, ScreenType.START);

    private GameLoop loop;
    private GameRenderer renderer;

    public GameScene() {

        canvas = new Canvas(UGV.SCREEN_WIDTH, UGV.SCREEN_HEIGHT);
        g = canvas.getGraphicsContext2D();

        canvas.setOnMouseClicked(this::handleMouseClick);

        this.getChildren().add(canvas);

        renderer = new GameRenderer();
        loop = new GameLoop(g, renderer, manager);

        loop.start();
    }

    private void handleMouseClick(MouseEvent event) {
        double mouseX = event.getX();
        double mouseY = event.getY();

        // Convert to grid coordinates
        int gridX = (int) ((mouseX - UGV.OFFSET_X) / UGV.TILE_SIZE);
        int gridY = (int) ((mouseY - UGV.OFFSET_Y) / UGV.TILE_SIZE);

        if (gridX >= 0 && gridX < UGV.RENDER_WIDTH && gridY >= 0 && gridY < UGV.RENDER_HEIGHT) {
            manager.handleMouseClick(event.getX(), event.getY());
        }
    }
}