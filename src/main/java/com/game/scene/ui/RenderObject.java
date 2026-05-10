package com.game.scene.ui;

import java.util.function.Function;

import com.game.UGV;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class RenderObject {

    protected final Image image;
    protected final Dimensions size;

    private final Function<Double, Double> xFunc;
    private final Function<Double, Double> yFunc;

    public RenderObject(
            String path,
            Function<Double, Double> xFunc,
            Function<Double, Double> yFunc) {
        this.image = new Image(getClass().getResourceAsStream(path));
        this.size = new Dimensions((image.getWidth() / 16.0) * UGV.TILE_SIZE,
                (image.getHeight() / 16.0) * UGV.TILE_SIZE);

        this.xFunc = xFunc;
        this.yFunc = yFunc;
    }

    public Coordinates getPosition() {
        double x = xFunc.apply(size.width());
        double y = yFunc.apply(size.height());
        return new Coordinates(x, y);
    }

    public void draw(GraphicsContext g) {
        Coordinates coordinates = getPosition();
        g.drawImage(image, coordinates.x(), coordinates.y(), size.width(), size.height());
    }
}
