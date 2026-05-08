package com.game.scene.engine;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.game.scene.background.BackgroundLoader;
import com.game.scene.background.BackgroundLayer;
import com.game.scene.layer.Layer;

import javafx.scene.canvas.GraphicsContext;

/**
 * A SceneObject is abstract because it represents a general
 * renderable game state, but not a concrete implementation.
 *
 * Screens and Overlays extend this class to provide specific
 * behavior and visuals.
 *
 * This allows SceneManager to treat all SceneObjects uniformly.
 * 
 * Capabilities:
 * 1. Composed of multiple layers
 * 2. Supports a background layer as part of its layer system
 * 3. Supports positional offsets during transitions
 */
public abstract class SceneObject implements Renderable {
    protected BackgroundLayer background;
    protected List<Layer> layers = new ArrayList<>();

    public void addLayer(Layer layer) {
        layers.add(layer);
    }

    public void update(double dt) {
        if (background != null)
            background.update(dt);
        for (Layer layer : layers) {
            layer.update(dt);
        }
    }

    public void drawLayers(GraphicsContext g) {
        if (background != null)
            background.draw(g);
        for (Layer layer : layers) {
            layer.draw(g);
        }
    }

    public void addBackground(BackgroundLoader loader, String path) {
        try {
            background = loader.loadBackground(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(GraphicsContext g, double offsetX, double offsetY) {

        g.save();
        g.translate(offsetX, offsetY);

        drawLayers(g);
        
        g.restore();
    }
}
