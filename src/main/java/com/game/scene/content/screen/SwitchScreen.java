package com.game.scene.content.screen;

import com.game.UGV;
import com.game.UGV.TileIndex;
import com.game.scene.background.BackgroundLoader;
import com.game.scene.engine.SceneManager;
import com.game.scene.layer.Layer;
import com.game.scene.transition.TransitionDefinition;

import javafx.scene.canvas.GraphicsContext;

/**
 * CURRENTLY in the works
 * 
 * It will be moved to its own folder like the start screen
 * 
 * We need pixel art for it
 */
class SwitchUiLayer implements Layer {

    SceneManager manager;

    public SwitchUiLayer(SceneManager manager) {
        this.manager = manager;
    }

    @Override
    public void update(double dt) {
    }

    @Override
    public void draw(GraphicsContext g) {
    }

    @Override
    public boolean handleMouseClick(double x, double y) {
        TileIndex index = UGV.getTileIndex(x, y);
        if (index.row == 0 && index.col == 0) {
            manager.changeScreen(ScreenDefinition.MAP, TransitionDefinition.SLIDE_IN_LEFT);
            return true;
        }
        return false;
    }

}

public class SwitchScreen extends Screen {

    public SwitchScreen(BackgroundLoader loader, SceneManager manager) {
        this.addBackground(loader, ScreenDefinition.SWITCH.resource("background.txt"));
        this.addLayer(new SwitchUiLayer(manager));
    }
}