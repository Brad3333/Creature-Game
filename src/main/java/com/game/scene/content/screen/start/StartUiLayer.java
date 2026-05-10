package com.game.scene.content.screen.start;

import com.game.scene.content.screen.ScreenDef;
import com.game.scene.engine.SceneManager;
import com.game.scene.layer.Layer;
import com.game.scene.transition.Direction;
import com.game.scene.transition.Transition;
import com.game.scene.ui.Pressable;
import com.game.scene.ui.RenderObject;
import com.game.scene.ui.UIUtils;

import javafx.scene.canvas.GraphicsContext;

class StartUiLayer implements Layer {
    private SceneManager manager;
    private StarterFrame[] frames = new StarterFrame[4];
    private StarterFrame selectedFrame = null;

    private final RenderObject Title = new RenderObject(ScreenDef.START.resource("CreatureConquestTitle.png"),
            UIUtils::centerX, y -> UIUtils.tileOffset(3.5));

    private final RenderObject Border = new RenderObject("/screens/StartBorder.png",
            x -> 0.0, y -> 0.0);

    private final Pressable StartButton = new Pressable(

            ScreenDef.START.resource("start_button.png"),

            () -> {
                manager.changeScene(ScreenDef.MAP, Transition.push(Direction.TOP));
            },

            UIUtils::centerX,
            y -> UIUtils.tileOffset(13));

    public StartUiLayer(SceneManager manager) {
        this.manager = manager;

        FrameType[] types = FrameType.values();
        for (int i = 0; i < types.length; i++) {
            double xPos = (7.0) * i + 2.0;
            frames[i] = new StarterFrame(types[i],
                    x -> UIUtils.tileOffset(xPos),
                    y -> UIUtils.tileOffset(7.0));
        }

        selectedFrame = frames[0];
    }

    @Override
    public void update(double dt) {
        StartButton.update(dt);
        for (StarterFrame frame : frames) {
            frame.update(frame == selectedFrame);
        }
    }

    @Override
    public void draw(GraphicsContext g) {

        Border.draw(g);
        Title.draw(g);
        StartButton.draw(g);
        for (StarterFrame frame : frames) {
            frame.draw(g);
        }
    }

    @Override
    public boolean handleMouseClick(double x, double y) {
        if (StartButton.handleMouseClick(x, y))
            return true;
        for (StarterFrame frame : frames) {
            if (frame.isClicked(x, y)) {
                System.out.println("Previewing: " + frame.getCreatureType());
                selectedFrame = frame;
                return true;
            }
        }
        return false;
    }

}