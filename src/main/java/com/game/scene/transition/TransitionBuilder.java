package com.game.scene.transition;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

import com.game.scene.content.SceneObjectFactory;
import com.game.scene.content.overlay.OverlayDef;

/**
 * TranstionBuilder allows us to chain together different transitions and stages
 */
public class TransitionBuilder {

    public static Deque<TransitionJob> getJobs(SceneObjectFactory sceneObject, Transition transition) {
        if (transition.type == TransitionType.VIEWPOINT) {
            return viewpointTransition(sceneObject, transition.direction);
        }
        return simpleTransition(sceneObject, transition);
    }

    /**
     * This is the Curtain like transition that is used when changing viewpoints
     * 
     * It should probably be used when going from the map to attack screen
     */
    private static Deque<TransitionJob> viewpointTransition(SceneObjectFactory sceneObject, Direction direction) {
        Deque<TransitionJob> jobs = new ArrayDeque<>();

        jobs.add(new TransitionJob(OverlayDef.CURTAIN, Transition.cover(CoverMode.IN, direction)));

        // Pause on the Curtain Overlay
        jobs.add(new TransitionJob(500));

        jobs.add(new TransitionJob(sceneObject, Transition.cover(CoverMode.OUT, direction)));

        return jobs;
    }

    private static Deque<TransitionJob> simpleTransition(SceneObjectFactory sceneObject, Transition transition) {
        return new ArrayDeque<>(
                List.of(new TransitionJob(sceneObject, transition)));
    }
}
