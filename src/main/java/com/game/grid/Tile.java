package com.game.grid;

import javafx.scene.image.Image;

public class Tile {
    public Image image;

    public Tile(String path) {
        this.image = new Image(getClass().getResource(path).toExternalForm());
    }
}
