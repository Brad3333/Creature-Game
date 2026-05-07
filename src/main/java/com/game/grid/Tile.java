package com.game.grid;

import javafx.scene.image.Image;

public class Tile {
    public Image image;


    //Store All Tiles Here
    public static final Tile TEST = new Tile("/test/test_tile.png");

    

    public Tile(String path) {
        this.image = new Image(getClass().getResource(path).toExternalForm());
    }

    public Tile(String path, boolean isSolid, int variant) {
        this.image = new Image(getClass().getResource(path).toExternalForm());
    }
}
