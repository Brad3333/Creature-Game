package com.game;

import com.game.scene.engine.SceneManager;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;

public class GameLoop extends AnimationTimer {

    private GraphicsContext g;

    private long lastTime = 0;
    private SceneManager sceneManager;

    public GameLoop(GraphicsContext g, SceneManager sceneManager) {
        this.g = g;
        this.sceneManager = sceneManager;
    }

    @Override
    public void handle(long now) {

        if (lastTime == 0) {
            lastTime = now;
            return;
        }

        double dt = (now - lastTime) / 1_000_000_000.0;
        lastTime = now;

        // Update our visuals
        sceneManager.update(dt);

        // Render the game
        sceneManager.draw(g);
    }

}