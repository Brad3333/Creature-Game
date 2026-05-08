package com.game.gui.screens.start;

import com.game.UGV;
import com.game.gui.Direction;
import com.game.gui.Layer;
import com.game.gui.ScreenManager;
import com.game.gui.screens.ScreenType;

import javafx.scene.canvas.GraphicsContext;

class StartUiLayer implements Layer {
    private ScreenManager manager;
    private StarterFrame[] frames = new StarterFrame[4];
    private StarterFrame selectedFrame = null; // Currently selected frame

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
        
        // Optional: Default to the first frame being selected
        selectedFrame = frames[0]; 
    }

    @Override
    public void update(double dt) {
        // Sync each frame's internal state with the Layer's selectedFrame
        for (StarterFrame frame : frames) {
            frame.update(frame == selectedFrame);
        }
    }

    @Override
    public void draw(GraphicsContext g) {
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
                // If the user clicks the one already selected, move to next screen
                if (selectedFrame == frame) {
                    System.out.println("Confirmed selection: " + frame.getType());
                    manager.changeScreen(ScreenType.SHOP, Direction.TOP);
                } else {
                    // Otherwise, just change the highlight
                    System.out.println("Previewing: " + frame.getType());
                    selectedFrame = frame;
                }
                return true;
            }
        }
        return false;
    }
}