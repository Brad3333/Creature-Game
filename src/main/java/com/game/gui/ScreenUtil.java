package com.game.gui;

import com.game.UGV;

public class ScreenUtil {
    public static double screenWidth() {
        return UGV.RENDER_WIDTH * UGV.TILE_SIZE;
    }

    public static double screenHeight() {
        return UGV.RENDER_HEIGHT * UGV.TILE_SIZE;
    }

    public static double getOffsetX(Direction dir, boolean current, double p) {
        if (dir == null)
            return 0;

        return switch (dir) {
            case LEFT -> current ? p : p - screenWidth();
            case RIGHT -> current ? -p : screenWidth() - p;
            default -> 0;
        };
    }

    public static double getOffsetY(Direction dir, boolean current, double p) {
        if (dir == null)
            return 0;
        return switch (dir) {
            case TOP -> current ? p : p - screenHeight();
            case BOTTOM -> current ? -p : screenHeight() - p;
            default -> 0;
        };
    }
}