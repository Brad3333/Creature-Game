package com.game.scene.content.overlay.curtain;

import com.game.scene.content.overlay.Overlay;
import com.game.scene.content.overlay.OverlayDef;
import com.game.scene.engine.SceneManager;

/**
 * CURRENTLY in the works
 * 
 * We need pixel art for it
 */
public class CurtainOverlay extends Overlay {

    public CurtainOverlay(SceneManager manager) {
        this.addBackground(OverlayDef.CURTAIN.resource("background.txt"));
    }

}
