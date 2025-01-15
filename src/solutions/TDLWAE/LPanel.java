package solutions.TDLWAE;

import javax.swing.*;
import java.awt.*;

public class LPanel extends JPanel implements Runnable {
    public static LPanel INSTANCE;
    public LPanel() {
        INSTANCE = this;
        KeyAction down = new KeyAction('s', new Action() {
            @Override
            public void run() {
                y+= 5;
            }
        });
        KeyAction up = new KeyAction('w', new Action() {
            @Override
            public void run() {
                y-= 5;
            }
        });
        KeyAction left = new KeyAction('a', new Action() {
            @Override
            public void run() {
                x-= 5;
            }
        });
        KeyAction right = new KeyAction('d', new Action() {
            @Override
            public void run() {
                x+= 5;
            }
        });
        TwentyDollarLockhartWithAnE.inputHandler.addListener(up);
        TwentyDollarLockhartWithAnE.inputHandler.addListener(down);
        TwentyDollarLockhartWithAnE.inputHandler.addListener(left);
        TwentyDollarLockhartWithAnE.inputHandler.addListener(right);

        Thread gt = new Thread(this);
        gt.start();
    }
    public int y = 20;
    public int x = 20;

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.yellow);
        g.fillRect(x, y, 200, 100);
    }

    public void run() {
        this.paintComponent(getGraphics());
    }
}
