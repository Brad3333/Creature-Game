package com.game.gui;

public class ScreenTransition {
    private final Direction direction;
    private double progress = 0;
    private final double speed = 1200;

    public ScreenTransition(Direction direction) {
        this.direction = direction;
    }

    public void update(double dt) {
        progress += speed * dt;
    }

    public double getProgress() { return progress; }
    public Direction getDirection() { return direction; }
    public boolean isDone(double limit) { return progress >= limit; }
}