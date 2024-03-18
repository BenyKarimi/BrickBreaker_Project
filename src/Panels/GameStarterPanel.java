package Panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

public class GameStarterPanel extends JPanel {

    Image image;
    JFrame frame;
    Level level;
    JButton button1, button2, button3;
    Color ball;
    String name;
    public GameStarterPanel(JFrame frame) {
        this.frame = frame;
        ball = new Color(255, 70, 70);

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

        JLabel label = new JLabel("Level");
        label.setFont(new Font("akashi", Font.BOLD, 45));
        label.setForeground(new Color(255, 224, 0));
        label.setBounds(120, 186, 500, 50);

        button1 = new JButton("Easy");
        button1.setContentAreaFilled(false);
        button1.setOpaque(false);
        button1.setBorderPainted(false);
        button1.setFocusable(false);
        button1.setFont(new Font("akashi", Font.BOLD, 35));
        button1.setForeground(new Color(255, 224, 0));
        button1.setBounds(125, 120, 500, 50);
        button1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                level = Level.EASY;
                button1.setForeground(new Color(255, 70, 70));
                button2.setForeground(new Color(255, 224, 0));
                button3.setForeground(new Color(255, 224, 0));
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

        button2 = new JButton("Medium");
        button2.setContentAreaFilled(false);
        button2.setOpaque(false);
        button2.setBorderPainted(false);
        button2.setFocusable(false);
        button2.setFont(new Font("akashi", Font.BOLD, 35));
        button2.setForeground(new Color(255, 224, 0));
        button2.setBounds(125, 190, 500, 50);
        button2.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                level = Level.MEDIUM;
                button2.setForeground(new Color(255, 70, 70));
                button1.setForeground(new Color(255, 224, 0));
                button3.setForeground(new Color(255, 224, 0));
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

        button3 = new JButton("Hard");
        button3.setContentAreaFilled(false);
        button3.setOpaque(false);
        button3.setBorderPainted(false);
        button3.setFocusable(false);
        button3.setFont(new Font("akashi", Font.BOLD, 35));
        button3.setForeground(new Color(255, 224, 0));
        button3.setBounds(125, 260, 500, 50);
        button3.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                level = Level.HARD;
                button3.setForeground(new Color(255, 70, 70));
                button1.setForeground(new Color(255, 224, 0));
                button2.setForeground(new Color(255, 224, 0));
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

        JButton ball_color = new JButton("Ball Color");
        ball_color.setContentAreaFilled(false);
        ball_color.setOpaque(false);
        ball_color.setBorderPainted(false);
        ball_color.setFocusable(false);
        ball_color.setFont(new Font("akashi", Font.BOLD, 45));
        ball_color.setForeground(new Color(255, 224, 0));
        ball_color.setBounds(120, 375, 500, 50);
        ball_color.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Color color = JColorChooser.showDialog(null, "Please Pick a color", ball);
                if (color != null) ball = color;
                repaint();
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                ball_color.setFont(new Font(ball_color.getFont().getFontName(), Font.BOLD, 50));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                ball_color.setFont(new Font(ball_color.getFont().getFontName(), Font.BOLD, 45));
            }
        });

        JLabel label1 = new JLabel("Enter name");
        label1.setFont(new Font("akashi", Font.BOLD, 45));
        label1.setForeground(new Color(255, 224, 0));
        label1.setBounds(225, 575, 500, 50);

        JTextField textField = new JTextField();
        textField.setOpaque(false);
        textField.setBorder(BorderFactory.createLineBorder(new Color(255, 224, 0), 2));
        textField.setForeground(new Color(255, 224, 0));
        textField.setCaretColor(Color.BLACK);
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setFont(new Font("akashi", Font.BOLD, 20));
        textField.setBounds(215, 650, 300, 50);

        JButton submit = new JButton("Submit");
        submit.setContentAreaFilled(false);
        submit.setOpaque(false);
        submit.setBorderPainted(false);
        submit.setFocusable(false);
        submit.setFont(new Font("akashi", Font.BOLD, 25));
        submit.setForeground(new Color(255, 224, 0));
        submit.setBounds(115, 705, 500, 50);
        submit.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                submit.setForeground(new Color(255, 70, 70));
                if (textField.getText().equals("")) {
                    JOptionPane.showMessageDialog(frame, "Please fill the text-field !", "WARNING" ,JOptionPane.WARNING_MESSAGE);
                }
                else name = textField.getText();
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                submit.setFont(new Font(submit.getFont().getFontName(), Font.BOLD, 30));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                submit.setFont(new Font(submit.getFont().getFontName(), Font.BOLD, 25));
                submit.setForeground(new Color(255, 224, 0));
            }
        });

        JButton start_button = new JButton("Start Game");
        start_button.setContentAreaFilled(false);
        start_button.setOpaque(false);
        start_button.setBorderPainted(false);
        start_button.setFocusable(false);
        start_button.setFont(new Font("akashi", Font.BOLD, 45));
        start_button.setForeground(new Color(255, 224, 0));
        start_button.setBounds(115, 825, 500, 50);
        start_button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (level == null) {
                    JOptionPane.showMessageDialog(frame, "Please choose the Level !", "WARNING", JOptionPane.WARNING_MESSAGE);
                }
                else if (name == null) {
                    JOptionPane.showMessageDialog(frame, "Please fill the text-field !", "WARNING", JOptionPane.WARNING_MESSAGE);

                }
                else {
                    frame.setContentPane(new GamePanel(frame, level, ball, name));
                    frame.pack();
                    frame.revalidate();
                    frame.repaint();
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
                start_button.setFont(new Font(start_button.getFont().getFontName(), Font.BOLD, 50));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                start_button.setFont(new Font(start_button.getFont().getFontName(), Font.BOLD, 45));
            }
        });

        image = new ImageIcon("Imported things/BackGround.png").getImage();
        this.setPreferredSize(new Dimension(image.getWidth(null) - 68, image.getHeight(null) - 444));
        this.setLayout(null);

        this.add(toMain);
        this.add(label);
        this.add(button1);
        this.add(button2);
        this.add(button3);
        this.add(ball_color);
        this.add(label1);
        this.add(textField);
        this.add(submit);
        this.add(start_button);
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
//                   System.out.println(e.getX() + " " + e.getY());
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null);
        g.setColor(ball);
        g.fillOval(340, 465, 40, 40);
    }
}
