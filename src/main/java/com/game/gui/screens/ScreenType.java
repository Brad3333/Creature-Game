package com.game.gui.screens;

import com.game.gui.Screen;
import com.game.gui.ScreenLoader;
import com.game.gui.ScreenManager;
import com.game.gui.screens.start.StartScreen;

public enum ScreenType {
    START {
        @Override
        public Screen create(ScreenLoader loader, ScreenManager manager) {
            return new StartScreen(loader, manager);
        }
    },
    ATTACK {
        @Override
        public Screen create(ScreenLoader loader, ScreenManager manager) {
            return new AttackScreen(loader, manager);
        }
    },
    MAP {
        @Override
        public Screen create(ScreenLoader loader, ScreenManager manager) {
            return new MapScreen(loader, manager);
        }
    },
    SHOP {
        @Override
        public Screen create(ScreenLoader loader, ScreenManager manager) {
            return new ShopScreen(loader, manager);
        }
    },
    SWITCH {
        @Override
        public Screen create(ScreenLoader loader, ScreenManager manager) {
            return new SwitchScreen(loader, manager);
        }
    },;

    public abstract Screen create(ScreenLoader loader, ScreenManager manager);
}