package com.game.gui.screens;

import com.game.UGV;
import com.game.gui.Direction;
import com.game.gui.Layer;
import com.game.gui.Screen;
import com.game.gui.ScreenLoader;
import com.game.gui.ScreenManager;

import javafx.scene.canvas.GraphicsContext;

import java.io.IOException;

class ShopUiLayer implements Layer {

    ScreenManager manager;

    public ShopUiLayer(ScreenManager manager) {
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
        System.out.println(UGV.OFFSET_X + ", " + UGV.OFFSET_Y);
        if (x > 100 && x < 200 && y > 50 && y < 100) {
            System.out.println("Button Pressed!");
            manager.changeScreen(ScreenType.START, Direction.BOTTOM);
            return true;
        }
        return false;
    }
}

public class ShopScreen extends Screen {

    public ShopScreen(ScreenLoader loader, ScreenManager manager) {
        try {
            this.addLayer(loader.loadBackground("/test/shop_screen.txt"));

            this.addLayer(new ShopUiLayer(manager));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}