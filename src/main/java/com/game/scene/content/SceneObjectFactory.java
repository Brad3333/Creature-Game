package com.game.scene.content;

import com.game.scene.background.BackgroundLoader;
import com.game.scene.engine.SceneObject;
import com.game.scene.engine.SceneManager;

/**
 * SceneObjectFactory is a contract that anything 
 * that implements it can create its SceneObject instance and
 * provide a base resource path for loading assets.
 * 
 * It is implemented in the Screen and Overlay definitions;
 * 
 */
public interface SceneObjectFactory {
    SceneObject create(BackgroundLoader loader, SceneManager manager);

    String getBasePath();

    default String resource(String file) {
        return getBasePath() + "/" + file;
    }
}
