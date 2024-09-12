package solutions.TDLWAE;

import javax.swing.*;
import java.awt.*;

public class LPanel extends JPanel implements Runnable {

    public LPanel() {
        Thread gt = new Thread(this);
        gt.start();
    }
    int y = 20;

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.yellow);
        g.fillRect(20, y++, 200, 100);
    }

    public void run() {

        this.paintComponent(getGraphics());

    }
}
