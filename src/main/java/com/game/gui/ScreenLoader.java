package com.game.gui;

import com.game.UGV;
import java.io.*;

public class ScreenLoader {

    public BackgroundLayer loadBackground(String path) throws IOException {
        int[][] grid = loadGridFromFile(path);
        return new BackgroundLayer(grid);
    }

    private int[][] loadGridFromFile(String path) throws IOException {
        InputStream stream = getClass().getResourceAsStream(path);
        if (stream == null) {
            throw new IOException("File not found: " + path);
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
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
        reader.close();
        return grid;
    }
}