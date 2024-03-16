package Panels;

import Helper.GameRandomHelper;
import Model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GamePanel extends JPanel implements ActionListener {
    Image image;
    JFrame frame;
    ArrayList<Brick> brickArrayList;
    ArrayList<RegularItem> regularItems;
    ArrayList<Ball> ballArrayList;
    final int panelWidth = 700;
    final int panelHeight = 900;
    final int brickHeight = 52;
    final int brickWidth = 98;
    int ballXPosition;
    int ballNumbers;
    int brickValue;
    int brickAddingValue, brickAndItemAddY;
    int mouseXPos, mouseYPos;
    Level level;
    Color ballColor;
    javax.swing.Timer timer;
    boolean aimTime, drawAim;
    JButton pauseButton;
    public GamePanel(JFrame frame, Level level, Color ballColor) {
        this.frame = frame;
        this.level = level;
        this.ballColor = ballColor;

        brickArrayList = new ArrayList<>();
        regularItems = new ArrayList<>();
        ballArrayList = new ArrayList<>();
        aimTime = true;
        drawAim = true;

        ballXPosition = GameRandomHelper.BallXPosition();
        brickAndItemAddY = GameRandomHelper.BrickAndItemAddY(level);
        AddBall(GameRandomHelper.BallNumbers());
        brickValue = GameRandomHelper.BrickValue(level);
        brickAddingValue = GameRandomHelper.BrickAddingValue(level);

        BricksAndItemsInitial();

        timer = new Timer(500, this);

        pauseButton = new JButton("Pause");
        pauseButton.setContentAreaFilled(false);
        pauseButton.setOpaque(false);
        pauseButton.setBorderPainted(false);
        pauseButton.setFocusable(false);
        pauseButton.setFont(new Font("akashi", Font.BOLD, 15));
        pauseButton.setForeground(new Color(255, 224, 0));
        pauseButton.setBounds(-25, 10, 150, 40);
        pauseButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (pauseButton.getText().equals("Pause")) {
                    pauseButton.setText("Resume");
                    timer.stop();
                    drawAim = false;
                    repaint();
                }
                else {
                    pauseButton.setText("Pause");
                    timer.start();
                    drawAim = true;
                    repaint();
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
                pauseButton.setFont(new Font(pauseButton.getFont().getFontName(), Font.BOLD, 20));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                pauseButton.setFont(new Font(pauseButton.getFont().getFontName(), Font.BOLD, 15));
            }
        });

        image = new ImageIcon("Imported things/BackGround.png").getImage();
        this.add(pauseButton);
        this.setPreferredSize(new Dimension(panelWidth, panelHeight));
        this.setLayout(null);

        timer.start();
//        this.addMouseMotionListener(new MouseMotionAdapter() {
//            @Override
//            public void mouseMoved(MouseEvent e) {
//                   System.out.println(e.getX() + " " + e.getY());
//            }
//        });
    }

    public void AddBall(int num) {
        for (int i = 0; i < num; i++) {
            Ball ball = new Ball(ballXPosition, 875, 0, 0);
            ballArrayList.add(ball);
            ballNumbers++;
        }
    }
    public void BricksAndItemsInitial() {
        ArrayList<Integer> bricksPosition = GameRandomHelper.BricksPosition(level);
        ArrayList<Integer> itemsPosition = GameRandomHelper.ItemsPosition(level, bricksPosition);
        int brickY;

        if (brickArrayList.size() == 0) {
            brickY = 55;
        }
        else {
            brickY = 1000;
            for (Brick brick : brickArrayList) {
                brickY = Math.min(brickY, brick.getyBegin());
            }
            for (RegularItem item : regularItems) {
                brickY = Math.min(brickY, item.getY() - (brickHeight / 2));
            }
            brickY -= 55;
        }

        for (int i = 0; i < bricksPosition.size(); i++) {
            if (i < 2) {
                brickArrayList.add(new Brick(brickWidth, brickHeight, bricksPosition.get(i) * 100, brickY, brickValue, BrickType.PLAIN, new Color(255, 224, 0)));
            }
            else {
                brickArrayList.add(new Brick(brickWidth, brickHeight, bricksPosition.get(i) * 100, brickY, brickValue, GameRandomHelper.BrickRandomType(), new Color(255, 224, 0)));
            }
        }
        brickValue += brickAddingValue;

        for (int i = 0; i < itemsPosition.size(); i++) {
            if (i < 2) {
                regularItems.add(new RegularItem((itemsPosition.get(i) * 100) + (brickWidth / 2) - 12, brickY + (brickHeight / 2) - 12, ItemType.ADD_BALL, new Color(0, 50, 255)));
            }
            else {
                regularItems.add(new RegularItem((itemsPosition.get(i) * 100) + (brickWidth / 2) - 12, brickY + (brickHeight / 2) - 12, GameRandomHelper.ItemRandomType(), new Color(0, 50, 255)));
            }
        }
    }
    @Override
    public void paintComponent(Graphics g) {
//        super.paint(g);
        // background
        g.drawImage(image, 0, 0, panelWidth, panelHeight, null);

        // draw balls
        drawBalls((Graphics2D) g);

        // draw Bricks and Items
        drawBricksAndItems((Graphics2D) g);

        // draw aim line
        if (aimTime && SettingPanel.aimOn && drawAim) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(ballColor);
            float[] dashPattern = {10, 5};
            BasicStroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dashPattern, 0.0f);
            g2d.setStroke(dashed);
            g2d.drawLine(ballXPosition + 12, 890, mouseXPos, mouseYPos);
        }
    }

    public void drawBalls(Graphics2D g) {
        if (aimTime) {
            g.setColor(ballColor);
            g.fillOval(ballXPosition, 875, 25, 25);
            g.setFont(new Font("akashi", Font.PLAIN, 15));
            g.drawString(Integer.valueOf(ballNumbers).toString(), ballXPosition + 7, 870);
        }
        else {
            g.setColor(ballColor);
            for (Ball ptr : ballArrayList) {
                g.fillOval(ptr.getX(), ptr.getY(), ptr.getWidth(), ptr.getHeight());
            }
        }
    }
    public void drawBricksAndItems(Graphics2D g) {
        // change printing with bricks or items type
        for (Brick ptr : brickArrayList) {
            g.setColor(ptr.getColor());
            g.fillRect(ptr.getxBegin(), ptr.getyBegin(), ptr.getWidth(), ptr.getHeight());
            g.setColor(new Color(0, 0, 0));
            g.setFont(new Font("akashi", Font.PLAIN, 15));
            g.drawString(Integer.valueOf(ptr.getValue()).toString(), ptr.getxBegin() + (ptr.getWidth() / 2) - 5, ptr.getyBegin() + (ptr.getHeight() / 2) + 4);
        }
        for (RegularItem ptr : regularItems) {
            g.setColor(ptr.getColor());
            g.fillOval(ptr.getX(), ptr.getY(), ptr.getWidth(), ptr.getHeight());
        }

        // finishing game if states

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (aimTime) {
            for (Brick ptr : brickArrayList) {
                ptr.setyBegin(ptr.getyBegin() + brickAndItemAddY);
            }
            for (RegularItem ptr : regularItems) {
                ptr.setY(ptr.getY() + brickAndItemAddY);
            }
            repaint();
            this.addMouseMotionListener(new MouseAdapter() {
                @Override
                public void mouseMoved(MouseEvent e) {
                    mouseXPos = e.getX();
                    mouseYPos = e.getY();
                    repaint();
                }
            });
            this.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    aimTime = false;
                    timer.setDelay(100);
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

                }
                @Override
                public void mouseExited(MouseEvent e) {

                }
            });
        }
        else {
            System.out.println("salam");
        }
    }
}
