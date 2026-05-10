package com.game.scene.content.screen.start;

import com.game.entities.CreatureType;

public enum FrameType {
    LIFE(CreatureType.LIFE, "/screens/start/LifeStarterFrame.png"),
    LIGHTNING(CreatureType.LIGHTNING, "/screens/start/LightningStarterFrame.png"),
    HORROR(CreatureType.HORROR, "/screens/start/HorrorStarterFrame.png"),
    CYBORG(CreatureType.CYBORG, "/screens/start/CyborgStarterFrame.png");

    private final CreatureType type;
    private final String path;

    FrameType(CreatureType type, String path) {
        this.type = type;
        this.path = path;
    }

    public CreatureType getCreatureType() {
        return type;
    }

    public String getImagePath() {
        return path;
    }
}