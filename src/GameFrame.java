import Panels.MainMenuPanel;

import javax.swing.*;

public class GameFrame extends JFrame {
    public GameFrame () {
        MainMenuPanel menuPanel = new MainMenuPanel(this);

        ImageIcon image = new ImageIcon("Imported things/logo.jpg");

        this.setIconImage(image.getImage());
        this.setTitle("Brick Breaker+");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setContentPane(menuPanel);

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
