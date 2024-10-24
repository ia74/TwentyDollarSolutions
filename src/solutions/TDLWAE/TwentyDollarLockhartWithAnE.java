package solutions.TDLWAE;

import javax.swing.*;
import java.awt.*;

public class TwentyDollarLockhartWithAnE {
    public static void main(String[] args) {
        JFrame window = new JFrame("LockhEart");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setPreferredSize(new Dimension(400, 400));

        JLabel label = new JLabel("Lockhart With An E");
        label.setLocation(20, 20);
        window.add(label);
        window.pack();

        LPanel panel = new LPanel();
        window.add(panel);
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
