package com.game;

import com.game.grid.TileManager;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class GameRenderer {

    TileManager tileManager = new TileManager();

    public void render(GraphicsContext g) {

        //clear black screen
        g.setFill(Color.BLACK);
        g.fillRect(0, 0, UGV.SCREEN_WIDTH, UGV.SCREEN_HEIGHT);
        
        g.setImageSmoothing(false);
        tileManager.draw(g);
    }
}