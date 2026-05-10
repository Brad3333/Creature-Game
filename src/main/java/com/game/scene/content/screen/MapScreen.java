package com.game.scene.content.screen;

import com.game.UGV;
import com.game.UGV.TileIndex;
import com.game.scene.background.BackgroundLoader;
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
class MapUiLayer implements Layer {

    SceneManager manager;

    private final RenderObject Border = new RenderObject("/screens/StartBorder.png",
            x -> 0.0, y -> 0.0);

    public MapUiLayer(SceneManager manager) {
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
        if (index.row == 0 && index.col == 0) { // Top Left goes back to Start
            manager.changeScene(ScreenDef.START, Transition.push(Direction.BOTTOM));
            return true;
        }
        if (index.row == 0 && index.col == 29) { // Top Right goes to Attack
            manager.changeScene(ScreenDef.ATTACK, Transition.viewPoint().setSpeed(2400));
            return true;
        }
        if (index.row == 19 && index.col == 29) { // Bottom Right goes to Switch
            manager.changeScene(ScreenDef.SWITCH, Transition.push(Direction.RIGHT));
            return true;
        }
        if (index.row == 19 && index.col == 0) { // Bottom Left goes to Shop
            manager.changeScene(ScreenDef.SHOP, Transition.push(Direction.LEFT));
            return true;
        }
        return false;
    }

}

public class MapScreen extends Screen {

    public MapScreen(BackgroundLoader loader, SceneManager manager) {
        this.addBackground(loader, ScreenDef.MAP.resource("background.txt"));
        this.addLayer(new MapUiLayer(manager));
    }

    @Override
    public void onEnter() {
        playMusic(ScreenDef.MAP.resource("area1/Theme.mp3"));
    }
}