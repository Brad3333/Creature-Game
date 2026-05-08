package com.game.scene.background;

import com.game.UGV;
import com.game.UGV.TileIndex;
import com.game.scene.layer.Layer;

import javafx.scene.canvas.GraphicsContext;

/**
 * BackgroundLayer is a special type of layer that draws Tiles based on a grid
 */
public class BackgroundLayer implements Layer {
    private final int[][] grid;

    public BackgroundLayer(int[][] grid) {
        this.grid = grid;
    }

    @Override
    public void update(double dt) {
    }

    @Override
    public void draw(GraphicsContext g) {
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[y].length; x++) {
                Tile tile = TileRegistry.get(grid[y][x]);
                if (tile == null)
                    continue;

                g.drawImage(
                        tile.image,
                        x * UGV.TILE_SIZE + UGV.OFFSET_X,
                        y * UGV.TILE_SIZE + UGV.OFFSET_Y,
                        UGV.TILE_SIZE,
                        UGV.TILE_SIZE);
            }
        }
    }

    @Override
    public boolean handleMouseClick(double x, double y) {
        TileIndex index = UGV.getTileIndex(x, y);
        if (index != null)
            return true;
        return false;
    }
    
}