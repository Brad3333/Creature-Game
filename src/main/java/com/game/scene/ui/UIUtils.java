package com.game.scene.ui;

import com.game.UGV;

public class UIUtils {

    public static double centerX(double objectWidth) {
        return (UGV.RENDER_WIDTH * UGV.TILE_SIZE - objectWidth) / 2.0;
    }

    public static double centerY(double objectHeight) {
        return (UGV.RENDER_HEIGHT * UGV.TILE_SIZE - objectHeight) / 2.0;
    }

    public static double tileOffset(double amount) {
        return UGV.TILE_SIZE * amount;
    }

}
