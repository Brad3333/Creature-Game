package com.game.scene.background;

import com.game.UGV;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * BackgroundLoader loads a text file into a 2D grid used for placing tiles
 * 
 */
public class BackgroundLoader {

    // Cache grids that have already been read
    private final Map<String, int[][]> cache = new HashMap<>();

    public BackgroundLayer loadBackground(String path) throws IOException {

        int[][] grid = cache.get(path);

        if (grid == null) {
            grid = loadGridFromFile(path);
            cache.put(path, grid);
        }

        return new BackgroundLayer(grid);
    }

    private int[][] loadGridFromFile(String path) throws IOException {
        InputStream stream = getClass().getResourceAsStream(path);

        if (stream == null) {
            throw new IOException("File not found: " + path);
        }

        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(stream))) {
            int[][] grid = new int[UGV.RENDER_HEIGHT][UGV.RENDER_WIDTH];

            for (int y = 0; y < UGV.RENDER_HEIGHT; y++) {
                String line = reader.readLine();

                if (line == null)
                    break;

                String[] parts = line.trim().split("\\s+");

                for (int x = 0; x < Math.min(parts.length, UGV.RENDER_WIDTH); x++) {

                    grid[y][x] = Integer.parseInt(parts[x]);
                }
            }

            return grid;
        }
    }
}