package com.game.gui.screens;

import com.game.gui.Screen;
import com.game.gui.ScreenLoader;
import com.game.gui.ScreenManager;

public enum ScreenType {
    START {
        @Override
        public Screen create(ScreenLoader loader, ScreenManager manager) {
            return new StartScreen(loader, manager);
        }
    },
    SHOP {
        @Override
        public Screen create(ScreenLoader loader, ScreenManager manager) {
            return new ShopScreen(loader, manager);
        }
    };

    public abstract Screen create(ScreenLoader loader, ScreenManager manager);
}