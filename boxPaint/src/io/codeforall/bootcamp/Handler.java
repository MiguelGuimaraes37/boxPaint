package io.codeforall.bootcamp;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Handler implements KeyboardHandler {

    public Keyboard keyboard;
    public MapEditor mapEditor;

    public Handler(MapEditor mapEditor) {
        this.mapEditor = mapEditor;
        keyboard = new Keyboard(this);
        createKeyboardEvents();
    }

    public void createKeyboardEvents() {

        KeyboardEvent keyboardEventRight = new KeyboardEvent();
        keyboardEventRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboardEventRight.setKey(KeyboardEvent.KEY_RIGHT);
        keyboard.addEventListener(keyboardEventRight);

        KeyboardEvent keyboardEventLeft = new KeyboardEvent();
        keyboardEventLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboardEventLeft.setKey(KeyboardEvent.KEY_LEFT);
        keyboard.addEventListener(keyboardEventLeft);

        KeyboardEvent keyboardEventDown = new KeyboardEvent();
        keyboardEventDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboardEventDown.setKey(KeyboardEvent.KEY_DOWN);
        keyboard.addEventListener(keyboardEventDown);

        KeyboardEvent keyboardEventUp = new KeyboardEvent();
        keyboardEventUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboardEventUp.setKey(KeyboardEvent.KEY_UP);
        keyboard.addEventListener(keyboardEventUp);

        KeyboardEvent keyboardEventSpace = new KeyboardEvent();
        keyboardEventSpace.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboardEventSpace.setKey(KeyboardEvent.KEY_SPACE);
        keyboard.addEventListener(keyboardEventSpace);

        KeyboardEvent keyboardEventH = new KeyboardEvent();
        keyboardEventH.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboardEventH.setKey(KeyboardEvent.KEY_H);
        keyboard.addEventListener(keyboardEventH);

        KeyboardEvent keyboardEventJ = new KeyboardEvent();
        keyboardEventJ.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboardEventJ.setKey(KeyboardEvent.KEY_J);
        keyboard.addEventListener(keyboardEventJ);

        KeyboardEvent keyboardEventQ = new KeyboardEvent();
        keyboardEventQ.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboardEventQ.setKey(KeyboardEvent.KEY_ESC);
        keyboard.addEventListener(keyboardEventQ);

        KeyboardEvent keyboardEventI = new KeyboardEvent();
        keyboardEventI.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboardEventI.setKey(KeyboardEvent.KEY_I);
        keyboard.addEventListener(keyboardEventI);

        KeyboardEvent keyboardEventS = new KeyboardEvent();
        keyboardEventS.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboardEventS.setKey(KeyboardEvent.KEY_S);
        keyboard.addEventListener(keyboardEventS);

        KeyboardEvent keyboardEventM = new KeyboardEvent();
        keyboardEventM.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboardEventM.setKey(KeyboardEvent.KEY_M);
        keyboard.addEventListener(keyboardEventM);

    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_RIGHT:
                if (mapEditor.isValidMove(Direction.RIGHT, mapEditor.getCursorX())) {
                    mapEditor.getCursor().moveRight();
                }
                break;
            case KeyboardEvent.KEY_LEFT:
                if (mapEditor.isValidMove(Direction.LEFT, mapEditor.getCursorX())) {
                    mapEditor.getCursor().moveLeft();
                }
                break;
            case KeyboardEvent.KEY_UP:
                if (mapEditor.isValidMove(Direction.UP, mapEditor.getCursorY())) {
                    mapEditor.getCursor().moveUp();
                }
                break;
            case KeyboardEvent.KEY_DOWN:
                if (mapEditor.isValidMove(Direction.DOWN, mapEditor.getCursorY())) {
                    mapEditor.getCursor().moveDown();
                }
                break;
            case KeyboardEvent.KEY_SPACE:
                mapEditor.paintBox();
                break;
            case KeyboardEvent.KEY_H:
                mapEditor.getCursor().setFill();
                break;
            case KeyboardEvent.KEY_J:
                mapEditor.clear();
                break;
            case KeyboardEvent.KEY_ESC:
                System.exit(0);
                break;
            case KeyboardEvent.KEY_S:
                mapEditor.storePaintedBoxes();
                break;
            case KeyboardEvent.KEY_I:
                mapEditor.loadPaintedBoxes();
                break;
            case KeyboardEvent.KEY_M:
                mapEditor.playSound();
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
