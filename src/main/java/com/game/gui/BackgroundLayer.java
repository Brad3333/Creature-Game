package com.game.gui;

import com.game.UGV;
import javafx.scene.canvas.GraphicsContext;

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
        int gridX = (int) ((x - UGV.OFFSET_X) / UGV.TILE_SIZE);
        int gridY = (int) ((y - UGV.OFFSET_Y) / UGV.TILE_SIZE);

        if (gridX >= 0 && gridX < UGV.RENDER_WIDTH && gridY >= 0 && gridY < UGV.RENDER_HEIGHT) {
            System.out.println("Tile clicked at: " + gridX + ", " + gridY);
            return true;
        }

        return false;
    }
}