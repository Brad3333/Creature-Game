package com.game.scene.background;

import com.game.scene.content.overlay.OverlayDef;
import com.game.scene.content.screen.ScreenDef;

import javafx.scene.image.Image;

public class Tile {
    public final Image image;

    // Placeholder for testing
    public static final Tile TEST = new Tile("/test/test_tile.png");
    public static final Tile RENDER = new Tile("/test/render_tile.png");

    // Grid tile for the starting screen
    public static final Tile START_GRID = new Tile(ScreenDef.START.resource("grid.png"));

    public static final Tile RED = new Tile(OverlayDef.CURTAIN.resource("Red.png"));

    public Tile(String path) {
        this.image = new Image(getClass().getResourceAsStream(path));
    }
}