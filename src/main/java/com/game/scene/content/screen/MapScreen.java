package com.game.scene.content.screen;

import com.game.UGV;
import com.game.UGV.TileIndex;
import com.game.scene.background.BackgroundLoader;
import com.game.scene.engine.SceneManager;
import com.game.scene.layer.Layer;
import com.game.scene.transition.TransitionDefinition;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * CURRENTLY in the works
 * 
 * It will be moved to its own folder like the start screen
 * 
 * We need pixel art for it
 */
class MapUiLayer implements Layer {

    SceneManager manager;
    private final Image BORDER = new Image(
            getClass().getResourceAsStream("/screens/GameBorder.png"));

    public MapUiLayer(SceneManager manager) {
        this.manager = manager;
    }

    @Override
    public void update(double dt) {
    }

    @Override
    public void draw(GraphicsContext g) {

        g.drawImage(BORDER, UGV.OFFSET_X, 0, UGV.TILE_SIZE * 30, UGV.TILE_SIZE * 20);
    }

    @Override
    public boolean handleMouseClick(double x, double y) {
        TileIndex index = UGV.getTileIndex(x, y);
        if (index.row == 0 && index.col == 0) { // Top Left goes back to Start
            manager.changeScreen(ScreenDefinition.START, TransitionDefinition.SLIDE_IN_BOTTOM);
            return true;
        }
        if (index.row == 0 && index.col == 29) { // Top Right goes to Attack
            manager.changeScreen(ScreenDefinition.ATTACK, TransitionDefinition.VIEWPOINT_TRANSITION);
            return true;
        }
        if (index.row == 19 && index.col == 29) { // Bottom Right goes to Switch
            manager.changeScreen(ScreenDefinition.SWITCH, TransitionDefinition.SLIDE_IN_RIGHT);
            return true;
        }
        if (index.row == 19 && index.col == 0) { // Bottom Left goes to Shop
            manager.changeScreen(ScreenDefinition.SHOP, TransitionDefinition.SLIDE_IN_LEFT);
            return true;
        }
        return false;
    }

}

public class MapScreen extends Screen {

    public MapScreen(BackgroundLoader loader, SceneManager manager) {
        this.addBackground(loader, ScreenDefinition.MAP.resource("background.txt"));
        this.addLayer(new MapUiLayer(manager));
    }
}