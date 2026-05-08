package com.game.scene.transition;

import com.game.UGV;

/*
    Transistion definitions
 */
public enum TransitionDefinition {

    SLIDE_IN_TOP, SLIDE_IN_BOTTOM,
    SLIDE_IN_LEFT, SLIDE_IN_RIGHT,
    VIEWPOINT_TRANSITION,
    NONE;

    /**
     * Used to determine when the animtion reached the end (or limit)
     */
    public double limit() {
        return switch (this) {
            case NONE -> 0;
            case SLIDE_IN_LEFT, SLIDE_IN_RIGHT -> UGV.PLAYABLE_WIDTH;
            default -> UGV.PLAYABLE_HEIGHT;
        };
    }

    /**
     * The current boolean is to indicate if we 
     * are getting the offset for the current screen or the next screen
     * 
     */

    public double xOffset(boolean current, double progress) {
        return switch (this) {
            case SLIDE_IN_LEFT -> current ? progress : progress - UGV.PLAYABLE_WIDTH;
            case SLIDE_IN_RIGHT -> current ? -progress : UGV.PLAYABLE_WIDTH - progress;
            default -> 0;
        };
    }

    public double yOffset(boolean current, double progress) {
        return switch (this) {
            case SLIDE_IN_TOP -> current ? progress : progress - UGV.PLAYABLE_HEIGHT;
            case SLIDE_IN_BOTTOM -> current ? -progress : UGV.PLAYABLE_HEIGHT - progress;
            default -> 0;
        };
    }
}