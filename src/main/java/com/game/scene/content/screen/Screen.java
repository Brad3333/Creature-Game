package com.game.scene.content.screen;

import com.game.scene.engine.Clickable;
import com.game.scene.engine.SceneObject;

import javafx.scene.canvas.GraphicsContext;

/**
 * A Screen is a SceneObject that also supports user input handling.
 *
 * Most gameplay visuals are composed within Screens using layers.
 */
public abstract class Screen extends SceneObject implements Clickable {

    @Override
    public void draw(GraphicsContext g) {
        drawLayers(g);
    }

    /**
     * Propagates mouse input through layers from top layer to the background layer.
     *
     * Each layer may consume the event by returning true.
     * If a layer consumes the event, propagation stops immediately.
     */
    public boolean handleMouseClick(double x, double y) {

        for (int i = layers.size() - 1; i >= 0; i--) {
            if (layers.get(i).handleMouseClick(x, y)) {
                return true;
            }
        }

        // Background last
        if (background != null && background.handleMouseClick(x, y))
            return true;

        return false;
    }

}