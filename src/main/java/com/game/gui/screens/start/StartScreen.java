package com.game.gui.screens.start;

import com.game.gui.Screen;
import com.game.gui.ScreenLoader;
import com.game.gui.ScreenManager;

import java.io.IOException;

public class StartScreen extends Screen {

    public StartScreen(ScreenLoader loader, ScreenManager manager) {
        try {
            this.addLayer(loader.loadBackground("/screens/start/background.txt"));

            this.addLayer(new StartUiLayer(manager));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}