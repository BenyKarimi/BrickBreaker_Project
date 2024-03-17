package Panels;

import javax.swing.*;
import java.awt.*;

public class FinishingPanel extends JPanel {
    JFrame frame;
    Image image;
    public FinishingPanel(JFrame frame) {
        this.frame = frame;

        image = new ImageIcon("Imported things/BackGround.png").getImage();
        this.setPreferredSize(new Dimension(image.getWidth(null) - 68, image.getHeight(null) - 444));
        this.setLayout(null);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null);
    }
}
