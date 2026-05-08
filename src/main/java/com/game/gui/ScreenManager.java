package com.game.gui;

import com.game.UGV;
import com.game.gui.screens.ScreenType;

import javafx.scene.canvas.GraphicsContext;

public class ScreenManager {
    private Screen currentScreen;
    private Screen nextScreen;
    private ScreenTransition transition;
    private final ScreenLoader loader;

    public ScreenManager(ScreenLoader loader, ScreenType initialType) {
        this.loader = loader;
        this.currentScreen = initialType.create(loader, this);
    }

    public void changeScreen(ScreenType type, Direction dir) {

        System.out.println("Changing to:" + type);

        if (transition != null)
            return;

        this.nextScreen = type.create(loader, this);
        this.transition = new ScreenTransition(dir);
    }

    public void handleMouseClick(double x, double y) {
        if (transition != null)
            return;

        if (currentScreen != null) {
            currentScreen.handleMouseClick(x, y);
        }
    }

    public void update(double dt) {
        if (currentScreen != null)
            currentScreen.update(dt);

        if (transition != null) {
            transition.update(dt);
            if (nextScreen != null)
                nextScreen.update(dt);

            double limit = (transition.getDirection() == Direction.LEFT ||
                    transition.getDirection() == Direction.RIGHT)
                            ? ScreenUtil.screenWidth()
                            : ScreenUtil.screenHeight();

            if (transition.isDone(limit)) {
                currentScreen = nextScreen;
                nextScreen = null;
                transition = null;
            }
        }
    }

    public void draw(GraphicsContext g) {

        g.save();
        g.beginPath();
        g.rect(UGV.OFFSET_X, UGV.OFFSET_Y,
                UGV.RENDER_WIDTH * UGV.TILE_SIZE,
                UGV.RENDER_HEIGHT * UGV.TILE_SIZE);
        g.clip();

        double p = (transition == null) ? 0 : transition.getProgress();

        Direction dir = (transition == null) ? null : transition.getDirection();

        if (currentScreen != null) {
            currentScreen.draw(g, ScreenUtil.getOffsetX(dir, true, p),
                    ScreenUtil.getOffsetY(dir, true, p));
        }

        if (transition != null && nextScreen != null) {
            nextScreen.draw(g, ScreenUtil.getOffsetX(dir, false, p),
                    ScreenUtil.getOffsetY(dir, false, p));
        }

        g.restore();
    }
}