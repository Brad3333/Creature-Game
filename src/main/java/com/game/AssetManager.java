package com.game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import javafx.scene.image.Image;
import javafx.scene.media.Media;

public final class AssetManager {

    private static final Map<String, Image> IMAGE_CACHE = new HashMap<>();
    private static final Map<String, Media> MEDIA_CACHE = new HashMap<>();
    private final static Map<String, int[][]> GRID_CACHE = new HashMap<>();

    private AssetManager() {
    }

    public static Image getImage(String path) {

        if (IMAGE_CACHE.containsKey(path)) {
            return IMAGE_CACHE.get(path);
        }

        Image image = new Image(
                AssetManager.class.getResourceAsStream(path));

        IMAGE_CACHE.put(path, image);

        return image;
    }

    public static Media getMedia(String path) {

        if (MEDIA_CACHE.containsKey(path)) {
            return MEDIA_CACHE.get(path);
        }

        Media media = new Media(
                AssetManager.class.getResource(path).toExternalForm());

        MEDIA_CACHE.put(path, media);

        return media;
    }

    public static int[][] getGrid(String path) throws IOException {

        if (GRID_CACHE.containsKey(path)) {
            return GRID_CACHE.get(path);
        }

        InputStream stream = AssetManager.class.getResourceAsStream(path);

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

            GRID_CACHE.put(path, grid);

            return grid;
        }

    }

    public static void clear() {
        IMAGE_CACHE.clear();
        MEDIA_CACHE.clear();
        GRID_CACHE.clear();
    }

}
