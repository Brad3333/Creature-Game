package com.game.scene.content.overlay;

import com.game.scene.content.SceneObjectFactory;
import com.game.scene.content.overlay.curtain.CurtainOverlay;
import com.game.scene.engine.SceneObject;
import com.game.scene.engine.SceneManager;

/**
 * OverlayDefinition implements the SceneObjectFactory so it
 * can create SceneObjects for the corresponding Overlay along with
 * create resource paths.
 */
public enum OverlayDef implements SceneObjectFactory {

    CURTAIN("/overlays/curtain");

    private final String path;

    OverlayDef(String path) {
        this.path = path;
    }

    public SceneObject create(SceneManager manager) {
        return switch (this) {
            case CURTAIN -> new CurtainOverlay(manager);
        };
    }

    @Override
    public String getBasePath() {
        return path;
    }
}