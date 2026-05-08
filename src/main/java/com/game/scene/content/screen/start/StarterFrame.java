package com.game.scene.content.screen.start;

import com.game.UGV;
import com.game.entities.CreatureType;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class StarterFrame {
    private final double FRAME_SIZE = UGV.TILE_SIZE * 5.0;

    private double x, y;
    private FrameType frameType;
    private CreatureType creatureType;
    private boolean isSelected = false; // Internal state

    public StarterFrame(double x, double y, FrameType type) {
        this.x = x;
        this.y = y;
        this.frameType = type;
        this.creatureType = frameType.getCreatureType();
    }

    public void update(boolean selected) {
        this.isSelected = selected;
    }

    public void draw(GraphicsContext g) {
        if (isSelected) {
            g.setStroke(Color.YELLOW);
            g.setLineWidth(3);
            g.strokeRect(UGV.OFFSET_X + x - 2, y - 2, FRAME_SIZE + 4, FRAME_SIZE + 4);
        }

        g.drawImage(frameType.getImage(), UGV.OFFSET_X + x, y, FRAME_SIZE, FRAME_SIZE);

        if (!isSelected) {
            g.setFill(new Color(0, 0, 0, 0.3));
            g.fillRect(UGV.OFFSET_X + x, y, FRAME_SIZE, FRAME_SIZE);
        }
    }

    public boolean isClicked(double mouseX, double mouseY) {
        return mouseX >= x && mouseX <= x + FRAME_SIZE &&
                mouseY >= y && mouseY <= y + FRAME_SIZE;
    }

    public FrameType getFrameType() {
        return this.frameType;
    }

    public CreatureType getCreatureType() {
        return this.creatureType;
    }

}