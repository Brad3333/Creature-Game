package com.game.gui;

import javafx.scene.image.Image;

public class Tile {
    public Image image;
    public boolean isCollidable;

    public static final Tile TEST = new Tile("/test/test_tile.png", false);
    public static final Tile RENDER = new Tile("/test/render_tile.png", false);

    public static final Tile STONE1 = new Tile("/test/stone_1.png", false);
    public static final Tile STONE2 = new Tile("/test/stone_2.png", false);
    public static final Tile STONE3 = new Tile("/test/stone_3.png", false);

    public static final Tile START_GRID = new Tile("/screens/start/grid.png", false);

    public Tile(String path, boolean isCollidable) {
        this.image = new Image(getClass().getResourceAsStream(path));
        this.isCollidable = isCollidable;
    }

    public static boolean isCollidable(Tile tile) {
        return tile.isCollidable;
    }

}