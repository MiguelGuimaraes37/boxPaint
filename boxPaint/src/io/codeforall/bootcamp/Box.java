package io.codeforall.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Box {
    private final Rectangle rectangle;
    private boolean painted;

    public Box(Rectangle rectangle) {
        this.rectangle = rectangle;
        this.painted = false;
    }

    public void setPainted(boolean painted) {
        this.painted = painted;
    }

    public void draw() {
        rectangle.draw();
    }

    public  void paintActions() {
        if (painted) {
            rectangle.draw();
            setPainted(false);
            return;
        }
            rectangle.setColor(Color.BLACK);
            rectangle.fill();
            setPainted(true);
    }

    public boolean isPainted() {
        return painted;
    }

    public int getX() {
        return this.rectangle.getX();
    }

    public int getY() {
        return this.rectangle.getY();
    }
}
