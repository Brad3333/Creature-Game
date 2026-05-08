package com.game;

import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;

public final class UGV { // UniversalGameVariables
        private static final Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();

        public static final int RENDER_WIDTH = 30;
        public static final int RENDER_HEIGHT = 20;

        // Use percentage of screen (e.g., 80% of screen) and cuts off extra pixels <
        // TILE_SIZE
        public static final float SCREEN_PERCENT = 0.8F;
        public static final int SCREEN_WIDTH = Math.max(720, (int) (screenBounds.getWidth() * SCREEN_PERCENT)
                        - (int) (screenBounds.getWidth() * SCREEN_PERCENT) % RENDER_WIDTH);
        public static final int SCREEN_HEIGHT = Math.max(500, (int) (screenBounds.getHeight() * SCREEN_PERCENT)
                        - (int) (screenBounds.getHeight() * SCREEN_PERCENT) % RENDER_HEIGHT);

        public static final int TILE_SIZE = Math.min(SCREEN_WIDTH / RENDER_WIDTH, SCREEN_HEIGHT / RENDER_HEIGHT);

        public static final int OFFSET_X = (SCREEN_WIDTH - RENDER_WIDTH * TILE_SIZE) / 2;
        public static final int OFFSET_Y = (SCREEN_HEIGHT - RENDER_HEIGHT * TILE_SIZE) / 2;

        public static final double PLAYABLE_WIDTH = RENDER_WIDTH * TILE_SIZE;
        public static final double PLAYABLE_HEIGHT = RENDER_HEIGHT * TILE_SIZE;

        public static final String GAME_TITLE = "Creature Conquest";

        public static final boolean isRunning = true;

        // public static int LIFE = ;
        // game speed ect..

        /**
         * Gets the absolute center X of the playable grid.
         */
        public static double getMidX() {
                return OFFSET_X + (RENDER_WIDTH * TILE_SIZE) / 2.0;
        }

        /**
         * Gets the absolute center Y of the playable grid.
         */
        public static double getMidY() {
                return OFFSET_Y + (RENDER_HEIGHT * TILE_SIZE) / 2.0;
        }

        /**
         * Converts a raw mouse X coordinate to a 0-indexed grid column.
         */
        public static int getGridX(double mouseX) {
                return (int) ((mouseX - OFFSET_X) / TILE_SIZE);
        }

        /**
         * Converts a raw mouse Y coordinate to a 0-indexed grid row.
         */
        public static int getGridY(double mouseY) {
                return (int) ((mouseY - OFFSET_Y) / TILE_SIZE);
        }

        /**
         * Useful for centering UI text: returns the X coordinate needed
         * to center an object of a specific width.
         */
        public static double centerX(double objectWidth) {
                return OFFSET_X + (RENDER_WIDTH * TILE_SIZE - objectWidth) / 2.0;
        }

        /**
         * Useful for centering UI text: returns the Y coordinate needed
         * to center an object of a specific width.
         */
        public static double centerY(double objectHeight) {
                return OFFSET_Y + (RENDER_HEIGHT * TILE_SIZE - objectHeight) / 2.0;
        }

        public static class TileIndex {
                public int row, col;

                public TileIndex(int col, int row) {
                        this.col = col;
                        this.row = row;
                }
        }

        /**
         * Returns the row and col index of the tile being clicked
         */
        public static TileIndex getTileIndex(double x, double y) {
                int gridX = (int) ((x - UGV.OFFSET_X) / UGV.TILE_SIZE);
                int gridY = (int) ((y - UGV.OFFSET_Y) / UGV.TILE_SIZE);

                if (gridX >= 0 && gridX < UGV.RENDER_WIDTH && gridY >= 0 && gridY < UGV.RENDER_HEIGHT) {
                        System.out.println("Tile clicked at: " + gridX + ", " + gridY);
                        return new TileIndex(gridX, gridY);
                }
                return null;
        }

}
