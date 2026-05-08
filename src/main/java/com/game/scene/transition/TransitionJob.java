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
    public final TransitionDefinition animation;

    public final long durationMs;

    public TransitionJob(SceneObjectFactory targetSceneObject, TransitionDefinition animation) {
        this.type = Type.SCREEN;
        this.targetSceneObject = targetSceneObject;
        this.animation = animation;
        this.durationMs = 0;
    }

    public TransitionJob(long durationMs) {
        this.type = Type.PAUSE;
        this.targetSceneObject = null;
        this.animation = null;
        this.durationMs = durationMs;
    }
}