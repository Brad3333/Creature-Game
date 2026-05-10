package com.game.scene.ui;

import java.util.function.Function;
import com.game.scene.engine.Clickable;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Pressable extends RenderObject implements Clickable {

    private Runnable onClick = () -> {
    };
    private boolean hovering = false;

    public Pressable(String path, Runnable onClick, Function<Double, Double> xFunc, Function<Double, Double> yFunc) {
        super(path, xFunc, yFunc);
        this.onClick = onClick;
    }

    public Pressable(String path, Function<Double, Double> xFunc, Function<Double, Double> yFunc) {
        super(path, xFunc, yFunc);
    }

    public void update(double dt) {
        hovering = inBounds(Input.mouseX, Input.mouseY);
    }

    @Override
    public boolean handleMouseClick(double mouseX, double mouseY) {
        if (isClicked(mouseX, mouseY)) {
            onClick.run();
            return true;
        }
        return false;
    }

    public boolean isClicked(double mouseX, double mouseY) {
        return inBounds(mouseX, mouseY);
    }

    public boolean inBounds(double mouseX, double mouseY) {
        Coordinates pos = getPosition();
        double x = pos.x();
        double y = pos.y();
        if (mouseX >= x && mouseX <= x + size.width() && mouseY >= y && mouseY <= y + size.height()) {
            return true;
        }
        return false;
    }

    public void draw(GraphicsContext g) {
        super.draw(g);

        Coordinates pos = getPosition();
        double x = pos.x();
        double y = pos.y();
        if (hovering) {
            g.setFill(new Color(1, 1, 1, 0.1));
            g.fillRect(x, y, size.width(), size.height());
        } 

    }

}
