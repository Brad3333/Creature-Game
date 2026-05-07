package com.game;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;

public class GameLoop extends AnimationTimer {

    private GraphicsContext g;
    private GameRenderer renderer;

    private long lastTime = 0;

    public GameLoop(GraphicsContext g, GameRenderer renderer) {
        this.g = g;
        this.renderer = renderer;
    }

    @Override
    public void handle(long now) {

        if (lastTime == 0) {
            lastTime = now;
            return;
        }

        double dt = (now - lastTime) / 1_000_000_000.0;
        lastTime = now;

        update(dt);
        render();
    }

    private void update(double dt) {
        // player.update()
        // world.update()
        // battle logic etc
    }

    private void render() {
        renderer.render(g);
    }
}