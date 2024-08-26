package io.codeforall.bootcamp;

import java.io.*;

public class FileManager {


    public void store(Grid grid) {

        try (FileOutputStream file = new FileOutputStream("src/PaintedBoxes.txt")) {

            for (Box box : grid.getBoxes()) {
                if (box.isPainted()) {
                    file.write(String.valueOf(1).getBytes());
                    continue;
                }

                file.write(String.valueOf(0).getBytes());

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void load(MapEditor mapEditor, Grid grid) {
        int counter = 0;

        try {
            FileInputStream fos = new FileInputStream("src/PaintedBoxes.txt");
            DataInputStream reader = new DataInputStream(fos);

            while (reader.available() > 0) {

                if(reader.read() % 2 != 0) {
                    mapEditor.paintBoxes(grid.getBoxes()[counter].getX(), grid.getBoxes()[counter].getY());
                }

                counter++;
            }


        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

    }

}
