package Panels;

import FileManagment.FileManager;
import GameApplication.BrickBreakerGame;

import javax.swing.*;
import javax.swing.text.Style;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;

public class FinishingPanel extends JPanel {
    JFrame frame;
    Image image;
    FileManager fileManager;
    public FinishingPanel(JFrame frame, LocalDate date, String username, int time, int score, Level level, Color ballColor) {
        this.frame = frame;

        if (SettingPanel.saveOn) {
            fileManager = new FileManager(date, username, time, score);
        }

        JLabel label = new JLabel("Game Finished");
        label.setFont(new Font("akashi", Font.BOLD, 50));
        label.setForeground(new Color(255, 224, 0));
        label.setBounds(150, 165, 500, 50);

        JLabel label1 = new JLabel("Score: " + score);
        label1.setFont(new Font("akashi", Font.BOLD, 50));
        label1.setForeground(new Color(255, 224, 0));
        label1.setBounds(200, 250, 500, 50);

        JButton button = new JButton("Restart");
        button.setContentAreaFilled(false);
        button.setOpaque(false);
        button.setBorderPainted(false);
        button.setFocusable(false);
        button.setFont(new Font("akashi", Font.BOLD, 40));
        button.setForeground(new Color(255, 224, 0));
        button.setBounds(175, 400, 350, 50);
        button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.setContentPane(new GamePanel(frame, level, ballColor, username));
                frame.pack();
                frame.revalidate();
                frame.repaint();
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setFont(new Font(button.getFont().getFontName(), Font.BOLD, 45));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                button.setFont(new Font(button.getFont().getFontName(), Font.BOLD, 40));
            }
        });

        JButton button1 = new JButton("Game Menu");
        button1.setContentAreaFilled(false);
        button1.setOpaque(false);
        button1.setBorderPainted(false);
        button1.setFocusable(false);
        button1.setFont(new Font("akashi", Font.BOLD, 40));
        button1.setForeground(new Color(255, 224, 0));
        button1.setBounds(175, 500, 350, 50);
        button1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.setContentPane(new GameStarterPanel(frame));
                frame.pack();
                frame.revalidate();
                frame.repaint();
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                button1.setFont(new Font(button1.getFont().getFontName(), Font.BOLD, 45));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                button1.setFont(new Font(button1.getFont().getFontName(), Font.BOLD, 40));
            }
        });

        JButton button2 = new JButton("Main Menu");
        button2.setContentAreaFilled(false);
        button2.setOpaque(false);
        button2.setBorderPainted(false);
        button2.setFocusable(false);
        button2.setFont(new Font("akashi", Font.BOLD, 40));
        button2.setForeground(new Color(255, 224, 0));
        button2.setBounds(175, 600, 350, 50);
        button2.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                frame.setContentPane(new MainMenuPanel(frame));
                frame.pack();
                frame.revalidate();
                frame.repaint();
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                button2.setFont(new Font(button2.getFont().getFontName(), Font.BOLD, 45));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                button2.setFont(new Font(button2.getFont().getFontName(), Font.BOLD, 40));
            }
        });

        image = new ImageIcon("Imported things/BackGround.png").getImage();
        this.setPreferredSize(new Dimension(image.getWidth(null) - 68, image.getHeight(null) - 444));
        this.setLayout(null);

        this.add(label);
        this.add(label1);
        this.add(button);
        this.add(button1);
        this.add(button2);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null);
    }
}
