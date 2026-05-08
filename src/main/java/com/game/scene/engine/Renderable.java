package com.game.scene.engine;

import javafx.scene.canvas.GraphicsContext;

/**
 * All renderable objects can be updated and drawn
 */
public interface Renderable {
    void update(double dt);
    void draw(GraphicsContext g);
}