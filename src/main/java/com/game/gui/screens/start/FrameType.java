package com.game.gui.screens.start;

import com.game.entities.CreatureType;

import javafx.scene.image.Image;

public enum FrameType {
    LIFE(CreatureType.LIFE, "/screens/start/LifeStarterFrame.png"),
    LIGHTNING(CreatureType.LIGHTNING, "/screens/start/LightningStarterFrame.png"),
    HORROR(CreatureType.HORROR, "/screens/start/HorrorStarterFrame.png"),
    CYBORG(CreatureType.CYBORG, "/screens/start/CyborgStarterFrame.png");

    private final CreatureType type;
    private final Image image;

    FrameType(CreatureType type, String path) {
        this.type = type;
        this.image = new Image(getClass().getResourceAsStream(path));
    }

    public CreatureType getCreatureType() {
        return type;
    }

    public Image getImage() {
        return image;
    }
}