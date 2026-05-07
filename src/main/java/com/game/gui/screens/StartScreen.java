package com.game.gui.screens;

import com.game.UGV;
import com.game.gui.Direction;
import com.game.gui.Layer;
import com.game.gui.Screen;
import com.game.gui.ScreenLoader;
import com.game.gui.ScreenManager;

import javafx.geometry.VPos;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

import java.io.IOException;

class StartUiLayer implements Layer {

    ScreenManager manager;

    public StartUiLayer(ScreenManager manager) {
        this.manager = manager;
    }

    @Override
    public void update(double dt) {
    }

    @Override
    public void draw(GraphicsContext g) {
        g.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
        g.setFill(Color.BLACK);

        g.setTextAlign(TextAlignment.CENTER);

        g.setTextBaseline(VPos.CENTER);

        double x = UGV.getMidX();
        double y = UGV.getMidY();

        g.fillText("Start", x, y);
    }

    @Override
    public boolean handleMouseClick(double x, double y) {
        int gridX = (int) ((x - UGV.OFFSET_X) / UGV.TILE_SIZE);
        int gridY = (int) ((y - UGV.OFFSET_Y) / UGV.TILE_SIZE);

        if (gridX >= 0 && gridX < UGV.RENDER_WIDTH && gridY >= 0 && gridY < UGV.RENDER_HEIGHT) {
            if (gridX == 14 && gridY == 9 || gridX == 15 && gridY == 9 || gridX == 14 && gridY == 10
                    || gridX == 15 && gridY == 10) {
                manager.changeScreen(ScreenType.SHOP, Direction.TOP);
                return true;
            }

        }

        return false;
    }
}

public class StartScreen extends Screen {

    public StartScreen(ScreenLoader loader, ScreenManager manager) {
        try {
            this.addLayer(loader.loadBackground("/test/start_screen.txt"));

            this.addLayer(new StartUiLayer(manager));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}