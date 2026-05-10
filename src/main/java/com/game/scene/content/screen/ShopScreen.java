package com.game.scene.content.screen;

import com.game.UGV;
import com.game.UGV.TileIndex;
import com.game.scene.engine.SceneManager;
import com.game.scene.layer.Layer;
import com.game.scene.transition.Direction;
import com.game.scene.transition.Transition;
import com.game.scene.ui.RenderObject;

import javafx.scene.canvas.GraphicsContext;

/**
 * CURRENTLY in the works
 * 
 * It will be moved to its own folder like the start screen
 * 
 * We need pixel art for it
 */
class ShopUiLayer implements Layer {

    private final RenderObject Border = new RenderObject("/screens/StartBorder.png",
            x -> 0.0, y -> 0.0);

    SceneManager manager;

    public ShopUiLayer(SceneManager manager) {
        this.manager = manager;
    }

    @Override
    public void update(double dt) {
    }

    @Override
    public void draw(GraphicsContext g) {
        Border.draw(g);
    }

    @Override
    public boolean handleMouseClick(double x, double y) {
        TileIndex index = UGV.getTileIndex(x, y);
        if (index.row() == 0 && index.col() == 0) {
            manager.changeScene(ScreenDef.MAP, Transition.push(Direction.RIGHT));
            return true;
        }
        return false;
    }

}

public class ShopScreen extends Screen {

    public ShopScreen(SceneManager manager) {
        this.addBackground(ScreenDef.SHOP.resource("background.txt"));
        this.addLayer(new ShopUiLayer(manager));
    }
}