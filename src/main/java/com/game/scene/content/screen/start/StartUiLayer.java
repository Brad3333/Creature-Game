package com.game.scene.content.screen.start;

import com.game.UGV;
import com.game.scene.content.screen.ScreenDefinition;
import com.game.scene.engine.SceneManager;
import com.game.scene.layer.Layer;
import com.game.scene.transition.TransitionDefinition;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

class StartUiLayer implements Layer {
    private SceneManager manager;
    private StarterFrame[] frames = new StarterFrame[4];
    private StarterFrame selectedFrame = null;

    private final Image TITLE = new Image(
            getClass().getResourceAsStream("/screens/start/CreatureConquestTitle.png"));

    private final Image BORDER = new Image(
            getClass().getResourceAsStream("/screens/GameBorder.png"));

    public StartUiLayer(SceneManager manager) {
        this.manager = manager;

        double gap = UGV.TILE_SIZE * 2.0;
        double yPos = UGV.TILE_SIZE * 7.0;
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

        g.drawImage(TITLE, UGV.centerX(UGV.TILE_SIZE * 26), UGV.TILE_SIZE * 3.5, UGV.TILE_SIZE * 26, UGV.TILE_SIZE * 3);
        g.drawImage(BORDER, UGV.OFFSET_X, 0, UGV.TILE_SIZE * 30, UGV.TILE_SIZE * 20);
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
                    manager.changeScreen(ScreenDefinition.MAP, TransitionDefinition.SLIDE_IN_TOP);
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