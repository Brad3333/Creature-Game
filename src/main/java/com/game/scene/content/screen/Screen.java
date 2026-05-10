package com.game.scene.content.screen;

import com.game.scene.engine.Clickable;
import com.game.scene.engine.SceneObject;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public abstract class Screen extends SceneObject implements Clickable {

    protected MediaPlayer music;

    @Override
    public void draw(GraphicsContext g) {
        drawLayers(g);
    }

    /**
     * Called when the screen becomes active.
     */
    public void onEnter() {

    }

    /**
     * Called when the screen is removed.
     */
    public void onExit() {
        stopMusic();
    }

    protected void playMusic(String path) {

        stopMusic();

        Media media = new Media(
            getClass().getResource(path).toExternalForm()
        );

        music = new MediaPlayer(media);
        music.setCycleCount(MediaPlayer.INDEFINITE);
        music.play();
    }

    protected void stopMusic() {
        if (music != null) {
            music.stop();
            music.dispose();
            music = null;
        }
    }

    /**
     * Propagates mouse input through layers from top layer to the background layer.
     */
    public boolean handleMouseClick(double x, double y) {

        for (int i = layers.size() - 1; i >= 0; i--) {
            if (layers.get(i).handleMouseClick(x, y)) {
                return true;
            }
        }

        if (background != null && background.handleMouseClick(x, y))
            return true;

        return false;
    }
}