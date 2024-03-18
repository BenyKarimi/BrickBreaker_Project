package Panels;

import GameApplication.BrickBreakerGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

public class SettingPanel extends JPanel {
    public static boolean aimOn = true;
    public static boolean saveOn = true;
    public static boolean songOn = true;
    Image image;

    public SettingPanel(JFrame frame) {

        JButton toMain = new JButton("Back");
        toMain.setContentAreaFilled(false);
        toMain.setOpaque(false);
        toMain.setBorderPainted(false);
        toMain.setFocusable(false);
        toMain.setFont(new Font("akashi", Font.BOLD, 20));
        toMain.setForeground(new Color(255, 224, 0));
        toMain.setBounds(0, 15, 125, 50);
        toMain.addMouseListener(new MouseListener() {
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
                toMain.setFont(new Font(toMain.getFont().getFontName(), Font.BOLD, 25));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                toMain.setFont(new Font(toMain.getFont().getFontName(), Font.BOLD, 20));
            }
        });

        JLabel label = new JLabel("Aim: ");
        label.setFont(new Font("akashi", Font.BOLD, 45));
        label.setForeground(new Color(255, 224, 0));
        label.setBounds(170, 175, 500, 50);

        JLabel label1 = new JLabel("Song: ");
        label1.setFont(new Font("akashi", Font.BOLD, 45));
        label1.setForeground(new Color(255, 224, 0));
        label1.setBounds(170, 350, 500, 50);

        JLabel label2 = new JLabel("Save: ");
        label2.setFont(new Font("akashi", Font.BOLD, 45));
        label2.setForeground(new Color(255, 224, 0));
        label2.setBounds(170, 525, 500, 50);

        JButton button = new JButton("On");
        button.setContentAreaFilled(false);
        button.setOpaque(false);
        button.setBorderPainted(false);
        button.setFocusable(false);
        button.setFont(new Font("akashi", Font.BOLD, 40));
        button.setForeground(new Color(255, 224, 0));
        button.setBounds(350, 175, 100, 50);
        button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (button.getText().equals("On")) {
                    aimOn = false;
                    button.setText("Off");
                    button.setForeground(new Color(255, 70, 70));
                }
                else {
                    aimOn = true;
                    button.setText("On");
                    button.setForeground(new Color(255, 224, 0));
                }
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

        JButton button1 = new JButton("On");
        button1.setContentAreaFilled(false);
        button1.setOpaque(false);
        button1.setBorderPainted(false);
        button1.setFocusable(false);
        button1.setFont(new Font("akashi", Font.BOLD, 40));
        button1.setForeground(new Color(255, 224, 0));
        button1.setBounds(350, 350, 100, 50);
        button1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (button1.getText().equals("On")) {
                    BrickBreakerGame.soundManager.stop();
                    songOn = false;
                    button1.setText("Off");
                    button1.setForeground(new Color(255, 70, 70));
                }
                else {
                    songOn = true;
                    BrickBreakerGame.soundManager.play();
                    button1.setText("On");
                    button1.setForeground(new Color(255, 224, 0));
                }
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

        JButton button2 = new JButton("On");
        button2.setContentAreaFilled(false);
        button2.setOpaque(false);
        button2.setBorderPainted(false);
        button2.setFocusable(false);
        button2.setFont(new Font("akashi", Font.BOLD, 40));
        button2.setForeground(new Color(255, 224, 0));
        button2.setBounds(350, 525, 100, 50);
        button2.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (button2.getText().equals("On")) {
                    saveOn = false;
                    button2.setText("Off");
                    button2.setForeground(new Color(255, 70, 70));
                }
                else {
                    saveOn = true;
                    button2.setText("On");
                    button2.setForeground(new Color(255, 224, 0));
                }
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

        this.add(toMain);
        this.add(label);
        this.add(label1);
        this.add(label2);
        this.add(button);
        this.add(button1);
        this.add(button2);

        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                   //System.out.println(e.getX() + " " + e.getY());
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null);
    }
}
