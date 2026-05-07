package com.game.grid;

import javafx.scene.canvas.GraphicsContext;

public class TileManager {
    public final int tileSize = 48;
    private Tile[][] map;

    public TileManager() {
        map = new Tile[10][10];
        loadMap();
    }

    private void loadMap() {
        map[0][0] = new Tile("/test/test_tile.png");
    }

    public void draw(GraphicsContext g) {
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[0].length; x++) {
                Tile t = new Tile("/test/test_tile.png");

                g.drawImage(t.image, x * tileSize, y * tileSize, tileSize, tileSize);
            }
        }
    }
}
