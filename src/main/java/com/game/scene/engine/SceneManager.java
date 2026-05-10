package com.game.scene.engine;

import com.game.UGV;
import com.game.scene.background.BackgroundLoader;
import com.game.scene.content.SceneObjectFactory;
import com.game.scene.content.screen.Screen;
import com.game.scene.content.screen.ScreenDef;
import com.game.scene.transition.TransitionBuilder;
import com.game.scene.transition.TransitionJob;
import com.game.scene.transition.Transition;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayDeque;
import java.util.Deque;

public class SceneManager {

    private SceneObject current;
    private SceneObject next;

    private Transition transition;
    private long pauseTimer = 0;

    private final BackgroundLoader loader;

    private Deque<TransitionJob> jobQueue = new ArrayDeque<>();

    public SceneManager(BackgroundLoader loader, ScreenDef initialType) {
        this.loader = loader;
        this.current = initialType.create(loader, this);

        if (current instanceof Screen screen) {
            screen.onEnter();
        }
    }

    public void changeScene(SceneObjectFactory type, Transition anim) {

        if (transition != null)
            return;

        jobQueue.clear();
        jobQueue = TransitionBuilder.getJobs(type, anim);
    }

    public void handleMouseClick(double x, double y) {
        // Only pass the click to clickable SceneObjects
        if (current != null && current instanceof Clickable clickable) {
            clickable.handleMouseClick(x, y);
        }
    }

    public void update(double dt) {

        // Pausing is used for transitions that have pauses in between for better effect
        if (pauseTimer > 0) {
            pauseTimer -= (long) (dt * 1000);
            return;
        }

        // Only update if we have a SceneObject
        if (current != null)
            current.update(dt);

        // Move on to the next transition
        if (transition == null && next == null && !jobQueue.isEmpty() && pauseTimer <= 0) {

            TransitionJob job = jobQueue.poll();

            // Set our pause timer if that the type of job we are doing
            if (job.type == TransitionJob.Type.PAUSE) {
                pauseTimer = job.durationMs;
                return;
            }

            // Set the next screen and transition utils
            next = job.targetSceneObject.create(loader, this);
            transition = job.transition;
        }

        // In the case of a transition
        if (transition != null) {

            transition.update(dt);

            if (next != null)
                next.update(dt);

            if (transition.isDone()) {

                if (current instanceof Screen currentScreen) {
                    currentScreen.onExit();
                }

                current = next;

                if (current instanceof Screen currentScreen) {
                    currentScreen.onEnter();
                }

                next = null;
                transition = null;
            }
        }
    }

    public void draw(GraphicsContext g) {

        // Black background (Useful due to the padding of the width on the left and
        // right)
        g.setFill(Color.BLACK);
        g.fillRect(0, 0, UGV.SCREEN_WIDTH, UGV.SCREEN_HEIGHT);

        // Important so pixel art doesn't get blurred
        g.setImageSmoothing(false);

        // This is drawn to clip anything drawn outside of our playable grid
        g.save();
        g.translate(UGV.OFFSET_X, UGV.OFFSET_Y);
        g.beginPath();
        g.rect(0, 0,
                UGV.PLAYABLE_WIDTH, UGV.PLAYABLE_HEIGHT);
        g.clip();

        double currentOffsetX = transition != null ? transition.xOffset(true) : 0;
        double currentOffsetY = transition != null ? transition.yOffset(true) : 0;

        // Draw both the current and next screens offset based on the calculations
        if (transition != null && transition.reverseDisplayOrder()) {

            if (next != null) {
                next.draw(g,
                        transition.xOffset(false),
                        transition.yOffset(false));
            }
            if (current != null)
                current.draw(g, currentOffsetX, currentOffsetY);

        } else {

            if (current != null)
                current.draw(g, currentOffsetX, currentOffsetY);

            if (transition != null && next != null) {
                next.draw(g,
                        transition.xOffset(false),
                        transition.yOffset(false));
            }

        }

        g.restore();
    }
}