package solutions.TDLWAE;

import java.util.function.Function;

public class KeyAction {
    char keycode;
    Action action;
    public KeyAction(char keycode, Action e) {
        this.keycode = keycode;
        this.action = e;
    }
    public synchronized void run() {
        action.run();
    }
}
