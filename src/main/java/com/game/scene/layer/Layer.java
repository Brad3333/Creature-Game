package com.game.scene.layer;

import com.game.scene.engine.Renderable;

/**
 * Layer allow for clicks to propogate through each other
 */
public interface Layer extends Renderable {
    // Return true to stop the click propogation at the current layer
    boolean handleMouseClick(double x, double y); 
}