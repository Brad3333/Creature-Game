package com.game.scene.transition;

import com.game.scene.content.SceneObjectFactory;


/**
 * TransitionJob holds the variables used during transitioning
 * 
 * Capabilities:
 *  1. Move to a new screen based on a Transition type
 *  2. Pause on a screen for a designated duration
 */
public class TransitionJob {

    public enum Type {
        SCREEN,
        PAUSE
    }

    public final Type type;

    public final SceneObjectFactory targetSceneObject;
    public final Transition transition;

    public final long durationMs;

    public TransitionJob(SceneObjectFactory targetSceneObject, Transition transition) {
        this.type = Type.SCREEN;
        this.targetSceneObject = targetSceneObject;
        this.transition = transition;
        this.durationMs = 0;
    }

    public TransitionJob(long durationMs) {
        this.type = Type.PAUSE;
        this.targetSceneObject = null;
        this.transition = null;
        this.durationMs = durationMs;
    }
}