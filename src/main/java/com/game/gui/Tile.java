package com.game.gui;

import javafx.scene.image.Image;

public class Tile {
    public final Image image;

    public static final Tile TEST = new Tile("/test/test_tile.png");
    public static final Tile RENDER = new Tile("/test/render_tile.png");
    public static final Tile STONE1 = new Tile("/test/stone_1.png");
    public static final Tile STONE2 = new Tile("/test/stone_2.png");
    public static final Tile STONE3 = new Tile("/test/stone_3.png");

    public Tile(String path) {
        this.image = new Image(getClass().getResourceAsStream(path));
    }
}