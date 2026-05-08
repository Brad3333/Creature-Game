package com.game.scene.transition;

/**
 * Utility class for TransitionDefinition.
 * 
 * This handles the state of the transition and internally calls
 * the methods on TransitionDefinition.
 */
public class TransitionUtils {
    private final TransitionDefinition direction;
    private double progress = 0;
    private final double speed = 1200;

    public TransitionUtils(TransitionDefinition direction) {
        this.direction = direction;
    }

    public void update(double dt) {
        progress += speed * dt;
    }

    public boolean isDone() {
        return progress >= direction.limit();
    }

    public double getOffsetX(boolean current) {
        return direction.xOffset(current, progress);
    }

    public double getOffsetY(boolean current) {
        return direction.yOffset(current, progress);
    }
}