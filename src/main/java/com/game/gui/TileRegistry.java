package com.game.gui;

import java.util.Map;

public class TileRegistry {
    private static final Map<Integer, Tile> TILES = Map.of(
            0, Tile.TEST,
            1, Tile.RENDER,
            2, Tile.STONE1,
            3, Tile.STONE2,
            4, Tile.STONE3,
            5, Tile.START_GRID);

    public static Tile get(int id) {
        return TILES.getOrDefault(id, Tile.TEST);
    }
}