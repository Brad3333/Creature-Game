package com.game.scene.content.screen.start;

import com.game.scene.background.BackgroundLoader;
import com.game.scene.content.screen.Screen;
import com.game.scene.content.screen.ScreenDef;
import com.game.scene.engine.SceneManager;

public class StartScreen extends Screen {

    public StartScreen(BackgroundLoader loader, SceneManager manager) {
        this.addBackground(loader, ScreenDef.START.resource("background.txt"));
        this.addLayer(new StartUiLayer(manager));
    }

    public void onEnter() {
        super.playMusic(ScreenDef.START.resource("Theme.mp3"));
    }

}