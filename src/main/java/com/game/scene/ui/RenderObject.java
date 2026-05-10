package com.game.scene.ui;

import java.util.function.Function;

import com.game.AssetManager;
import com.game.UGV;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * RenderObject takes in a x and y function for determining the x and y coordinates
 * 
 * The width or height respectively is given into each function if needed for calculation
 * 
 * Example 1:
 * 
 * RenderObject obj = new RenderObject(imagePath, w -> 0.0, h -> 0.0);
 * 
 * This would put the image at (0, 0), w is for width which is being passed into 
 * the lambda function but it isnt being used, so for easier readability I will be 
 * making my objects like this when I don't need size dimensions in my x and y functions:
 * 
 * RenderObject obj = new RenderObject(imagePath, x -> 0.0, y -> 0.0);
 * 
 * In my opinion this is more readable since it looks like we are saying 
 * x is 0.0 and y is 0.0.
 * 
 * Example 2:
 * 
 * RenderObject obj = new RenderObject(imagePath, 
 *    w -> UIUtils.centerX(w), h -> UIUtils.tileOffset(2.0));
 * 
 * This is where the conventions becomes powerful and useful, we can pass in premade 
 * functions to determine the coordinates like cenerting the object which will relate to 
 * its width. And maybe for the y, offset it 2 tiles down. This can also be re-written
 * for better readability.
 * 
 * RenderObject obj = new RenderObject(imagePath, 
 *    UIUtils::centerX, y -> UIUtils.tileOffset(2.0));
 * 
 * This way is simpler and easier to understands, its saying 
 * use the centerX function from UIUtils and set y to a tileOffset of 2.
 * 
 * 
 */
public class RenderObject {

    protected final Image image;
    protected final Dimensions size;
    protected Coordinates position;

    private final Function<Double, Double> xFunc;
    private final Function<Double, Double> yFunc;

    public RenderObject(
            String path,
            Function<Double, Double> xFunc,
            Function<Double, Double> yFunc) {
        this.image = AssetManager.getImage(path);
        this.size = new Dimensions((image.getWidth() / 16.0) * UGV.TILE_SIZE,
                (image.getHeight() / 16.0) * UGV.TILE_SIZE);

        this.xFunc = xFunc;
        this.yFunc = yFunc;
        this.updatePosition();
    }

    private void updatePosition() {
        double x = xFunc.apply(size.width());
        double y = yFunc.apply(size.height());
        this.position = new Coordinates(x, y);
    }

    public Coordinates getPosition() {
        return this.position;
    }

    public void draw(GraphicsContext g) {
        Coordinates coordinates = getPosition();
        g.drawImage(image, coordinates.x(), coordinates.y(), size.width(), size.height());
    }
}
