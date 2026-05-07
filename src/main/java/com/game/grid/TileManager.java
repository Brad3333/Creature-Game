package com.game.grid;

import com.game.UGV;

import javafx.scene.canvas.GraphicsContext;

public class TileManager {
    private Tile[][] map;


    public TileManager() {
        map = new Tile[UGV.RENDER_WIDTH][UGV.RENDER_HEIGHT];
        loadMap();
    }

    private void loadMap() {
        map[0][0] = Tile.TEST;
    }

    public void draw(GraphicsContext g) {
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[0].length; x++) {
                

                g.drawImage(Tile.TEST.image, y * UGV.TILE_SIZE + UGV.OFFSET_X, x * UGV.TILE_SIZE + UGV.OFFSET_Y, UGV.TILE_SIZE, UGV.TILE_SIZE);
            }
        }
    }
}