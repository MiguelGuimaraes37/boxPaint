package io.codeforall.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cursor {

    private final Rectangle rectangle;
    private boolean isFill;

    public Cursor(Rectangle rectangle) {
        this.rectangle = rectangle;
        rectangle.fill();
        rectangle.setColor(Color.GREEN);
        isFill = true;
    }

    public void fill() {
        rectangle.fill();
    }

    public void setFill() {
        if (isFill) {
            draw();
            isFill = false;
        } else {
            fill();
            isFill = true;
        }
    }

    public void draw() {
        rectangle.draw();
    }

    public int getX() {
        return rectangle.getX();
    }

    public int getY() {
        return rectangle.getY();
    }

    public void moveRight() {
        rectangle.translate(20, 0);
    }

    public void moveUp() {
        rectangle.translate(0, -20);
    }

    public void moveDown() {
        rectangle.translate(0, 20);
    }

    public void moveLeft() {
        rectangle.translate(-20, 0);
    }
}