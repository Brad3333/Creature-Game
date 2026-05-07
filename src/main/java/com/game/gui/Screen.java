package com.game.gui;

import javafx.scene.canvas.GraphicsContext;
import java.util.ArrayList;
import java.util.List;

public abstract class Screen {
    private List<Layer> layers = new ArrayList<>();

    public void addLayer(Layer layer) {
        layers.add(layer);
    }

    public void update(double dt) {
        for (Layer layer : layers) {
            layer.update(dt);
        }
    }

    public void draw(GraphicsContext g, double offsetX, double offsetY) {
        g.save();
        g.translate(offsetX, offsetY);
        for (Layer layer : layers) {
            layer.draw(g);
        }
        g.restore();
    }

    public boolean handleMouseClick(double x, double y) {
        for (int i = layers.size() - 1; i >= 0; i--) {
            if (layers.get(i).handleMouseClick(x, y)) {
                return true;
            }
        }
        return false;
    }

}