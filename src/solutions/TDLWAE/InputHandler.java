package solutions.TDLWAE;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

public class InputHandler implements KeyListener {
    Component component;
    HashMap<Character, Action> keyActionMap = new HashMap<>();
    public InputHandler(Component e) {
        this.component = e;
        e.addKeyListener(this);
    }
    public void addListener(KeyAction keyAction) {
        keyActionMap.put(keyAction.keycode, keyAction.action);
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(keyActionMap.containsKey(e.getKeyChar())) {
            keyActionMap.get(e.getKeyChar()).run();
        }
        e.consume();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
