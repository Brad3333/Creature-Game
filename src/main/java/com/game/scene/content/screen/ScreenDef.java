package com.game.scene.content.screen;

import com.game.scene.content.SceneObjectFactory;
import com.game.scene.content.screen.start.StartScreen;
import com.game.scene.engine.SceneObject;
import com.game.scene.engine.SceneManager;

/**
 * ScreenDefinition implements the SceneObjectFactory so it
 * can create SceneObjects for the corresponding Overlay along with
 * create resource paths.
 */
public enum ScreenDef implements SceneObjectFactory {

    START("/screens/start"),
    ATTACK("/screens/attack"),
    MAP("/screens/map"),
    SHOP("/screens/shop"),
    SWITCH("/screens/switch");

    private final String path;

    ScreenDef(String path) {
        this.path = path;
    }

    public SceneObject create(SceneManager manager) {
        return switch (this) {
            case START -> new StartScreen(manager);
            case ATTACK -> new AttackScreen(manager);
            case MAP -> new MapScreen(manager);
            case SHOP -> new ShopScreen(manager);
            case SWITCH -> new SwitchScreen(manager);
        };
    }

    @Override
    public String getBasePath() {
        return path;
    }
}