package com.game.scene.transition;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

import com.game.scene.content.SceneObjectFactory;
import com.game.scene.content.overlay.OverlayDefinition;

/**
 * TranstionBuilder allows us to chain together different transitions and stages
 */
public class TransitionBuilder {

    public static Deque<TransitionJob> getJobs(SceneObjectFactory sceneObject, TransitionDefinition type) {
        return switch (type) {
            case VIEWPOINT_TRANSITION -> viewpointTransition(sceneObject);

            // Most will default to a 1 stage transition until we make more custom ones
            default -> simpleTransition(sceneObject, type);
        };
    }

    /**
     * This is the Curtain like transition that is used when changing viewpoints
     * 
     * It should probably be used when going from the map to attack screen
     */
    private static Deque<TransitionJob> viewpointTransition(SceneObjectFactory sceneObject) {
        Deque<TransitionJob> jobs = new ArrayDeque<>();

        jobs.add(new TransitionJob(OverlayDefinition.CURTAIN, TransitionDefinition.SLIDE_IN_TOP));

        // Pause on the Curtain Overlay
        jobs.add(new TransitionJob(500));
        
        jobs.add(new TransitionJob(sceneObject, TransitionDefinition.SLIDE_IN_BOTTOM));

        return jobs;
    }

    private static Deque<TransitionJob> simpleTransition(SceneObjectFactory sceneObject, TransitionDefinition type) {
        return new ArrayDeque<>(
                List.of(new TransitionJob(sceneObject, type)));
    }
}
