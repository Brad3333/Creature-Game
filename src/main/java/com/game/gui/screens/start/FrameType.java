package com.game.gui.screens.start;

import javafx.scene.image.Image;

public enum FrameType {
    LIFE("/screens/start/LifeStarterFrame.png"),
    THUNDER("/screens/start/ThunderStarterFrame.png"),
    HORROR("/screens/start/HorrorStarterFrame.png"),
    CYBORG("/screens/start/CyborgStarterFrame.png");

    private final Image image;

    FrameType(String path) {
        this.image = new Image(getClass().getResourceAsStream(path));
    }

    public Image getImage() {
        return image;
    }
}