package com.game.scene.content.overlay.curtain;

import com.game.scene.background.BackgroundLoader;
import com.game.scene.content.overlay.Overlay;
import com.game.scene.content.overlay.OverlayDef;
import com.game.scene.engine.SceneManager;

/**
 * CURRENTLY in the works
 * 
 * We need pixel art for it
 */
public class CurtainOverlay extends Overlay {

    public CurtainOverlay(BackgroundLoader loader, SceneManager manager) {
        this.addBackground(loader, OverlayDef.CURTAIN.resource("background.txt"));
    }

}
