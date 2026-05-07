package com.game.gui.screens.start;

import com.game.UGV;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class StarterFrame {
    private final double FRAME_SIZE = UGV.TILE_SIZE * 5.0;
    
    private double x, y;
    private FrameType type;
    private boolean isSelected = false; // Internal state

    public StarterFrame(double x, double y, FrameType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void update(boolean selected) {
        this.isSelected = selected;
    }

    public void draw(GraphicsContext g) {
        // 1. Draw a "Selection Glow" or border if selected
        if (isSelected) {
            g.setStroke(Color.YELLOW);
            g.setLineWidth(3);
            g.strokeRect(UGV.OFFSET_X + x - 2, y - 2, FRAME_SIZE + 4, FRAME_SIZE + 4);
        }

        g.drawImage(type.getImage(), UGV.OFFSET_X + x, y, FRAME_SIZE, FRAME_SIZE);
        
        if (!isSelected) {
            g.setFill(new Color(0, 0, 0, 0.3)); // Semi-transparent black
            g.fillRect(UGV.OFFSET_X + x, y, FRAME_SIZE, FRAME_SIZE);
        }
    }

    public boolean isClicked(double mouseX, double mouseY) {
        return mouseX >= x && mouseX <= x + FRAME_SIZE &&
               mouseY >= y && mouseY <= y + FRAME_SIZE;
    }

    public FrameType getType() { return type; }
}