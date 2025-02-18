package solutions.TDLWAE;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

public class TwentyDollarLockhartWithAnE {
    public static InputHandler inputHandler;
    public static void main(String[] args) {
        JFrame window = new JFrame("LockhEart");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setPreferredSize(new Dimension(400, 400));
        inputHandler = new InputHandler(window);

        int x = 1;
        JLabel label = new JLabel("Lockhart With An E");
        label.setLocation(x++, 20);
        window.add(label);
        window.pack();

        LPanel panel = new LPanel();

        window.add(panel);
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        while(true) {
            window.repaint();
        }
    }
}
