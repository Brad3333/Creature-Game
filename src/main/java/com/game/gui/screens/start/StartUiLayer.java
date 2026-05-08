package com.game.gui.screens.start;

import com.game.UGV;
import com.game.gui.Direction;
import com.game.gui.Layer;
import com.game.gui.ScreenManager;
import com.game.gui.screens.ScreenType;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

class StartUiLayer implements Layer {
    private ScreenManager manager;
    private StarterFrame[] frames = new StarterFrame[4];
    private StarterFrame selectedFrame = null;

    private final Image TITLE = new Image(
            getClass().getResourceAsStream("/screens/start/CreatureConquestTitle.png"));

    public StartUiLayer(ScreenManager manager) {
        this.manager = manager;

        double gap = UGV.TILE_SIZE * 2.0;
        double yPos = UGV.TILE_SIZE * 5.0;
        double frameWidth = UGV.TILE_SIZE * 5.0;

        FrameType[] types = FrameType.values();
        for (int i = 0; i < types.length; i++) {
            double xPos = (gap + frameWidth) * i + gap;
            frames[i] = new StarterFrame(xPos, yPos, types[i]);
        }

        selectedFrame = frames[0];
    }

    @Override
    public void update(double dt) {
        for (StarterFrame frame : frames) {
            frame.update(frame == selectedFrame);
        }
    }

    @Override
    public void draw(GraphicsContext g) {

        g.drawImage(TITLE, UGV.centerX(UGV.TILE_SIZE * 26), UGV.TILE_SIZE * 1.5, UGV.TILE_SIZE * 26, UGV.TILE_SIZE * 3);

        for (StarterFrame frame : frames) {
            frame.draw(g);
        }
    }

    @Override
    public boolean handleMouseClick(double x, double y) {
        double localX = x - UGV.OFFSET_X;
        double localY = y - UGV.OFFSET_Y;

        for (StarterFrame frame : frames) {
            if (frame.isClicked(localX, localY)) {
                if (selectedFrame == frame) {
                    System.out.println("Confirmed selection: " + frame.getCreatureType());
                    manager.changeScreen(ScreenType.MAP, Direction.TOP);
                } else {
                    System.out.println("Previewing: " + frame.getCreatureType());
                    selectedFrame = frame;
                }
                return true;
            }
        }
        return false;
    }
}