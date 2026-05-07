package com.game;

import com.game.gui.ScreenManager;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class GameRenderer {

    public void render(GraphicsContext g, ScreenManager screenManager) {

        //clear black screen
        g.setFill(Color.BLACK);
        g.fillRect(0, 0, UGV.SCREEN_WIDTH, UGV.SCREEN_HEIGHT);
        
        g.setImageSmoothing(false);
        screenManager.draw(g);
    }
}