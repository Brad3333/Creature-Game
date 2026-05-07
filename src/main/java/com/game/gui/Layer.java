package com.game.gui;

import javafx.scene.canvas.GraphicsContext;

public interface Layer {
    void update(double dt);
    void draw(GraphicsContext g);
    
    // Return true to stop the click propogation
    boolean handleMouseClick(double x, double y); 
}