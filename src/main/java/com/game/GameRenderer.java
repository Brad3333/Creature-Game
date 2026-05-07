package com.game;

import com.game.grid.TileManager;

import javafx.scene.canvas.GraphicsContext;

public class GameRenderer {

    TileManager tileManager = new TileManager();

    public void render(GraphicsContext g) {

        // clear screen
        g.clearRect(0, 0, 800, 600);
        g.setImageSmoothing(false);

        tileManager.draw(g);
    }
}