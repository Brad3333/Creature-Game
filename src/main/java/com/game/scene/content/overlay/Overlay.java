package com.game.scene.content.overlay;

import com.game.scene.engine.SceneObject;

import javafx.scene.canvas.GraphicsContext;

/**
 * Overlay is the most basic form of SceneObject with nothing new added
 * 
 * In the future we can add things to it here for more functionality
 */
public abstract class Overlay extends SceneObject {

    public void draw(GraphicsContext g) {
        drawLayers(g);
    }
}
