package com.game;

import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;

public final class UGV { //UniversalGameVariables
    private static final Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
    
    public static final int RENDER_WIDTH = 30;
    public static final int RENDER_HEIGHT = 20;

    // Use percentage of screen (e.g., 80% of screen) and cuts off extra pixels < TILE_SIZE
    public static final int SCREEN_WIDTH = (int)(screenBounds.getWidth() * 0.8) - (int)(screenBounds.getWidth() * 0.8) % RENDER_WIDTH;
    public static final int SCREEN_HEIGHT = (int)(screenBounds.getHeight() * 0.8) - (int)(screenBounds.getHeight() * 0.8) % RENDER_HEIGHT;

    public static final int TILE_SIZE = Math.min(SCREEN_WIDTH / RENDER_WIDTH, SCREEN_HEIGHT / RENDER_HEIGHT);

    public static final int OFFSET_X = (SCREEN_WIDTH - RENDER_WIDTH * TILE_SIZE) / 2;
    public static final int OFFSET_Y = (SCREEN_HEIGHT - RENDER_HEIGHT * TILE_SIZE) / 2;

    public static final String GAME_TITLE = "Creature Game";

    public static final boolean isRunning = true;


    //public static int LIFE = ;
    //game speed ect..

}
