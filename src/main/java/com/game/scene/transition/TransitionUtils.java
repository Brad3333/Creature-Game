package com.game.scene.transition;

/**
 * Utility class for TransitionDefinition.
 * 
 * This handles the state of the transition and internally calls
 * the methods on TransitionDefinition.
 */
public class TransitionUtils {
    private final Transition transition;
    private double progress = 0;
    private final double speed = 1200;

    public TransitionUtils(Transition transition) {
        this.transition = transition;
    }

    public void update(double dt) {
        progress = Math.min(progress + speed * dt, transition.limit());
    }

    public boolean isDone() {
        return progress >= transition.limit();
    }

    public double getOffsetX(boolean current) {
        return transition.xOffset(current);
    }

    public double getOffsetY(boolean current) {
        return transition.yOffset(current);
    }

    public boolean reverseDisplayOrder() {
        return transition.coverMode == CoverMode.OUT;
    }

}