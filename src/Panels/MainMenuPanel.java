package Panels;

import FileManagment.FileManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class MainMenuPanel extends JPanel {

    JFrame frame;
    Image image;

    JButton button1, button2, button3, button4;

    public MainMenuPanel(JFrame frame) {
        this.frame = frame;

        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, new File("Imported things/akashi.ttf"));
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(font);
        } catch (IOException | FontFormatException e) {
            throw new RuntimeException(e);
        }

        JLabel label = new JLabel("Brick");
        label.setFont(new Font("akashi", Font.BOLD, 75));
        label.setForeground(new Color(255, 224, 0));
        label.setBounds(170, 68, 500, 50);

        JLabel label1 = new JLabel("Breaker");
        label1.setFont(new Font("akashi", Font.BOLD, 75));
        label1.setForeground(new Color(255, 224, 0));
        label1.setBounds(270, 136, 500, 50);

        button1 = new JButton("Start new Game");
        button1.setContentAreaFilled(false);
        button1.setOpaque(false);
        button1.setBorderPainted(false);
        button1.setFocusable(false);
        button1.setFont(new Font("akashi", Font.BOLD, 35));
        button1.setForeground(new Color(255, 224, 0));
        button1.setBounds(115, 350, 500, 50);
        button1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.setContentPane(new GameStarterPanel(frame));
                frame.pack();
                frame.repaint();
                frame.revalidate();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                button1.setFont(new Font(button1.getFont().getFontName(), Font.BOLD, 40));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button1.setFont(new Font(button1.getFont().getFontName(), Font.BOLD, 35));
            }
        });

        button2 = new JButton("Show History");
        button2.setContentAreaFilled(false);
        button2.setOpaque(false);
        button2.setBorderPainted(false);
        button2.setFocusable(false);
        button2.setFont(new Font("akashi", Font.BOLD, 35));
        button2.setForeground(new Color(255, 224, 0));
        button2.setBounds(115, 450, 500, 50);
        button2.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.setContentPane(new ShowHistoryPanel(frame));
                frame.pack();
                frame.repaint();
                frame.revalidate();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                button2.setFont(new Font(button2.getFont().getFontName(), Font.BOLD, 40));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button2.setFont(new Font(button2.getFont().getFontName(), Font.BOLD, 35));
            }
        });

        button3 = new JButton("Settings");
        button3.setContentAreaFilled(false);
        button3.setOpaque(false);
        button3.setBorderPainted(false);
        button3.setFocusable(false);
        button3.setFont(new Font("akashi", Font.BOLD, 35));
        button3.setForeground(new Color(255, 224, 0));
        button3.setBounds(115, 550, 500, 50);
        button3.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.setContentPane(new SettingPanel(frame));
                frame.pack();
                frame.repaint();
                frame.revalidate();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                button3.setFont(new Font(button3.getFont().getFontName(), Font.BOLD, 40));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button3.setFont(new Font(button3.getFont().getFontName(), Font.BOLD, 35));
            }
        });

        button4 = new JButton("Exit");
        button4.setContentAreaFilled(false);
        button4.setOpaque(false);
        button4.setBorderPainted(false);
        button4.setFocusable(false);
        button4.setFont(new Font("akashi", Font.BOLD, 35));
        button4.setForeground(new Color(255, 224, 0));
        button4.setBounds(115, 650, 500, 50);
        button4.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                button4.setFont(new Font(button4.getFont().getFontName(), Font.BOLD, 40));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button4.setFont(new Font(button4.getFont().getFontName(), Font.BOLD, 35));
            }
        });

        // edit Record number after Game Finished
        JLabel label2 = new JLabel("Record: " + FileManager.GetMaxScore());
        label2.setFont(new Font("akashi", Font.BOLD, 40));
        label2.setForeground(new Color(255, 224, 0));
        label2.setBounds(250, 845, 500, 50);

        image = new ImageIcon("Imported things/BackGround.png").getImage();
        this.setPreferredSize(new Dimension(image.getWidth(null) - 68, image.getHeight(null) - 444));
        this.setLayout(null);

        this.add(label);
        this.add(label1);
        this.add(button1);
        this.add(button2);
        this.add(button3);
        this.add(button4);
        this.add(label2);

        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
             //   System.out.println(e.getX() + " " + e.getY());
            }
        });
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null);
    }
}
