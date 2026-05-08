package com.game.scene.background;

import java.util.Map;

public class TileRegistry {
    private static final Map<Integer, Tile> TILES = Map.of(
            0, Tile.TEST,
            1, Tile.RENDER,
            2, Tile.START_GRID,
            3, Tile.RED);

    public static Tile get(int id) {
        return TILES.getOrDefault(id, Tile.TEST);
    }
}