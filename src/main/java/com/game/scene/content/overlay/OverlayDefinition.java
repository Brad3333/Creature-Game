package com.game.scene.content.overlay;

import com.game.scene.background.BackgroundLoader;
import com.game.scene.content.SceneObjectFactory;
import com.game.scene.content.overlay.curtain.CurtainOverlay;
import com.game.scene.engine.SceneObject;
import com.game.scene.engine.SceneManager;

/**
 * OverlayDefinition implements the SceneObjectFactory so it
 * can create SceneObjects for the corresponding Overlay along with
 * create resource paths.
 */
public enum OverlayDefinition implements SceneObjectFactory {

    CURTAIN("/overlays/curtain");

    private final String path;

    OverlayDefinition(String path) {
        this.path = path;
    }

    public SceneObject create(BackgroundLoader loader, SceneManager manager) {
        return switch (this) {
            case CURTAIN -> new CurtainOverlay(loader, manager);
        };
    }

    @Override
    public String getBasePath() {
        return path;
    }
}