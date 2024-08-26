package io.codeforall.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class MapEditor {

    private Grid grid;
    private static final int widthPlayer = 20;
    private static final int heightPlayer = 20;
    private Cursor cursor;
    private FileManager fileManager;
    private SoundManager soundManager;

    public MapEditor(int width, int height) {

        if(width % 20 == 0 && height %  20 == 0) {
            grid = new Grid(width, height, widthPlayer, heightPlayer);
            cursor = new Cursor(new Rectangle(10,10,20, 20));
            fileManager = new FileManager();
            soundManager = new SoundManager();
        } else {
            System.out.println("values of Grid must be multiples of both the length and height of the cursor, 20");
        }

    }

    public int getCursorX() {
        return cursor.getX();
    }

    public int getCursorY() {
        return cursor.getY();
    }

    public Cursor getCursor() {
        return cursor;
    }

    public void paintBox() {

        for (Box box : grid.getBoxes()) {

            if (box.getX() == cursor.getX() && box.getY() == cursor.getY()) {

                box.paintActions();

                break;

            }
        }

    }

    public void paintBoxes(int x, int y) {

        for (Box box : grid.getBoxes()) {

            if (box.getX() == x && box.getY() == y) {

                box.paintActions();

                break;

            }
        }
    }

    public void clear() {
        grid.clear();
    }

    public boolean isValidMove(Direction direction, int moveAxis) {

        if (direction == Direction.UP || direction == Direction.LEFT) {

            return moveAxis - 10 >= widthPlayer;

        } else {

            return moveAxis + widthPlayer <= grid.getWidth();

        }

    }

    public void storePaintedBoxes() {
        fileManager.store(grid);
    }

    public void loadPaintedBoxes() {
        fileManager.load(this, grid);
    }

    public void playSound() {
        soundManager.playSound();
    }

}
