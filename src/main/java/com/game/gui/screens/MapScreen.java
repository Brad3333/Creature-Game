package com.game.gui.screens;

import com.game.UGV;
import com.game.UGV.TileIndex;
import com.game.gui.Direction;
import com.game.gui.Layer;
import com.game.gui.Screen;
import com.game.gui.ScreenLoader;
import com.game.gui.ScreenManager;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.io.IOException;

class MapUiLayer implements Layer {

    ScreenManager manager;
    private final Image BORDER = new Image(
            getClass().getResourceAsStream("/screens/GameBorder.png"));

    public MapUiLayer(ScreenManager manager) {
        this.manager = manager;
    }

    @Override
    public void update(double dt) {
    }

    @Override
    public void draw(GraphicsContext g) {

        g.drawImage(BORDER, UGV.OFFSET_X, 0, UGV.TILE_SIZE * 30, UGV.TILE_SIZE * 20);
    }

    @Override
    public boolean handleMouseClick(double x, double y) {
        TileIndex index = UGV.getTileIndex(x, y);
        if (index.row == 0 && index.col == 0) { // Top Left goes back to Start
            manager.changeScreen(ScreenType.START, Direction.BOTTOM);
            return true;
        }
        if (index.row == 0 && index.col == 29) { // Top Right goes to Attack
            manager.changeScreen(ScreenType.ATTACK, Direction.TOP);
            return true;
        }
        if (index.row == 19 && index.col == 29) { // Bottom Right goes to Attack
            manager.changeScreen(ScreenType.SWITCH, Direction.RIGHT);
            return true;
        }
        if (index.row == 19 && index.col == 0) { // Bottom Left goes to Attack
            manager.changeScreen(ScreenType.SHOP, Direction.LEFT);
            return true;
        }
        return false;
    }
}

public class MapScreen extends Screen {

    public MapScreen(ScreenLoader loader, ScreenManager manager) {
        try {
            this.addLayer(loader.loadBackground("/screens/map/background.txt"));

            this.addLayer(new MapUiLayer(manager));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}