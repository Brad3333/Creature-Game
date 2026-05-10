package com.game.scene.content.screen.start;

import java.util.function.Function;

import com.game.entities.CreatureType;
import com.game.scene.ui.Coordinates;
import com.game.scene.ui.Pressable;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class StarterFrame extends Pressable {

    private FrameType frameType;
    private CreatureType creatureType;
    private boolean isSelected = false;

    public StarterFrame(FrameType type, Function<Double, Double> xFunc,
            Function<Double, Double> yFunc) {
        super(type.getImagePath(), xFunc, yFunc);
        this.frameType = type;
        this.creatureType = frameType.getCreatureType();
    }

    public void update(boolean selected) {
        super.update(0);
        this.isSelected = selected;
    }

    public void draw(GraphicsContext g) {
        Coordinates coordinates = super.getPosition();
        double x = coordinates.x();
        double y = coordinates.y();

        if (isSelected) {
            g.setStroke(Color.BLACK);
            g.setLineWidth(3);
            g.strokeRect(x - 2, y - 2, size.width() + 4, size.height() + 4);
        }
        
        super.draw(g);

        if (!isSelected) {
            g.setFill(new Color(0, 0, 0, 0.3));
            g.fillRect(x, y, size.width(), size.height());
        }
    }

    public FrameType getFrameType() {
        return this.frameType;
    }

    public CreatureType getCreatureType() {
        return this.creatureType;
    }

}