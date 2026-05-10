package com.game.scene.transition;

import com.game.UGV;

/*
    Transistion definitions
 */
public class Transition {

    public final TransitionType type;
    public final Direction direction;
    public final CoverMode coverMode;
    private double progress = 0;
    private double speedPPS = 1200;

    public Transition(
            TransitionType type,
            Direction direction,
            CoverMode coverMode) {
        this.type = type;
        this.direction = direction;
        this.coverMode = coverMode;
    }

    /**
     * Instead of writing annoying object constructing I made these functions
     * below to make the job easier since we will mainly be doing the smae transitions
     * 
     */

    public static Transition push(Direction direction) {
        return new Transition(TransitionType.PUSH, direction, null);
    }

    public static Transition cover(CoverMode coverMode, Direction direction) {
        return new Transition(TransitionType.COVER, direction, coverMode);
    }

    public static Transition viewPoint() {
        return new Transition(TransitionType.VIEWPOINT, Direction.TOP, null);
    }

    public static Transition viewPoint(Direction direction) {
        return new Transition(TransitionType.VIEWPOINT, direction, null);
    }

    public static Transition none() {
        return new Transition(TransitionType.NONE, null, null);
    }

    /**
     * Should be called on creation of the object
     */
    public Transition setSpeed(double speedMs) {
        getPixelsPerSecond(speedMs);
        return this;
    }

    /**
     * Used to determine when the animtion reached the end (or limit)
     */
    public double limit() {
        if (type == TransitionType.NONE)
            return 0;
        return switch (direction) {
            case LEFT, RIGHT -> UGV.PLAYABLE_WIDTH;
            case TOP, BOTTOM -> UGV.PLAYABLE_HEIGHT;
        };
    }

    private void getPixelsPerSecond(double speedMs) {
        this.speedPPS = limit() / (speedMs / 1000.0);
    }

    public boolean isDone() {
        return progress >= limit();
    }

    public void update(double dt) {
        //progress = Math.min(progress + speedPPS * dt, limit());
        progress += speedPPS * dt;
    }

    public boolean reverseDisplayOrder() {
        return coverMode == CoverMode.OUT;
    }

    /**
     * The current boolean is to indicate if we
     * are getting the offset for the current screen or the next screen
     */
    public double xOffset(boolean current) {
        return switch (direction) {
            case LEFT -> switch (type) {
                case PUSH -> current ? progress : progress - UGV.PLAYABLE_WIDTH;
                case COVER -> switch (coverMode) {
                    case IN -> current ? 0 : progress - UGV.PLAYABLE_WIDTH;
                    case OUT -> current ? -progress : 0;
                    default -> 0;
                };
                default -> 0;
            };
            case RIGHT -> switch (type) {
                case PUSH -> current ? -progress : UGV.PLAYABLE_WIDTH - progress;
                case COVER -> switch (coverMode) {
                    case IN -> current ? 0 : UGV.PLAYABLE_WIDTH - progress;
                    case OUT -> current ? progress : 0;
                    default -> 0;
                };
                default -> 0;
            };
            default -> 0;
        };
    }

    public double yOffset(boolean current) {
        return switch (direction) {
            case TOP -> switch (type) {
                case PUSH -> current ? progress : progress - UGV.PLAYABLE_HEIGHT;
                case COVER -> switch (coverMode) {
                    case IN -> current ? 0 : progress - UGV.PLAYABLE_HEIGHT;
                    case OUT -> current ? -progress : 0;
                    default -> 0;
                };
                default -> 0;
            };
            case BOTTOM -> switch (type) {
                case PUSH -> current ? -progress : UGV.PLAYABLE_HEIGHT - progress;
                case COVER -> switch (coverMode) {
                    case IN -> current ? 0 : UGV.PLAYABLE_HEIGHT - progress;
                    case OUT -> current ? progress : 0;
                    default -> 0;
                };
                default -> 0;
            };
            default -> 0;
        };
    }

}