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
class ShopUiLayer implements Layer {

    SceneManager manager;

    public ShopUiLayer(SceneManager manager) {
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
            manager.changeScreen(ScreenDefinition.MAP, TransitionDefinition.SLIDE_IN_RIGHT);
            return true;
        }
        return false;
    }

}

public class ShopScreen extends Screen {

    public ShopScreen(BackgroundLoader loader, SceneManager manager) {
        this.addBackground(loader, ScreenDefinition.SHOP.resource("background.txt"));
        this.addLayer(new ShopUiLayer(manager));
    }
}