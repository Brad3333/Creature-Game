package com.game.gui.screens;

import com.game.UGV;
import com.game.UGV.TileIndex;
import com.game.gui.Direction;
import com.game.gui.Layer;
import com.game.gui.Screen;
import com.game.gui.ScreenLoader;
import com.game.gui.ScreenManager;

import javafx.scene.canvas.GraphicsContext;

import java.io.IOException;

class AttackUiLayer implements Layer {

    ScreenManager manager;

    public AttackUiLayer(ScreenManager manager) {
        this.manager = manager;
    }

    @Override
    public void update(double dt) {
    }

    @Override
    public void draw(GraphicsContext g) {
    }

    @Override
    public boolean handleMouseClick(double x, double y) {
        TileIndex index = UGV.getTileIndex(x, y);
        if (index.row == 0 && index.col == 0) {
            manager.changeScreen(ScreenType.MAP, Direction.BOTTOM);
            return true;
        }
        return false;
    }
}

public class AttackScreen extends Screen {

    public AttackScreen(ScreenLoader loader, ScreenManager manager) {
        try {
            this.addLayer(loader.loadBackground("/screens/attack/background.txt"));
            
            this.addLayer(new AttackUiLayer(manager));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}