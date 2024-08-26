package io.codeforall.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Grid {

    private final int width;
    private final int height;
    private final Box[] boxes;


    public Grid(int width, int height, int widthPlayer, int heightPlayer) {
        this.width = width;
        this.height = height;

        int numberOfBoxes = (this.width / widthPlayer) * (this.height / heightPlayer);

        Box[] arrayBox = new Box[numberOfBoxes];

        int x = widthPlayer - 10;
        int y = heightPlayer - 10;


        for (int i = 0; i < numberOfBoxes; i++) {

            if (i != 0) {

                if (i % (width / widthPlayer) == 0) {
                    x = widthPlayer - 10;
                    y += heightPlayer;
                } else {
                    x += widthPlayer;
                }

            }

            arrayBox[i] = new Box(new Rectangle(x, y, widthPlayer, heightPlayer));
            arrayBox[i].draw();

        }

        boxes = arrayBox;
    }

    public int getWidth() {
        return width;
    }

    public Box[] getBoxes() {
        return boxes;
    }

    public void clear() {
        for(Box box : boxes) {
            box.draw();
        }
    }


}
