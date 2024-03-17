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
    javax.swing.Timer timer, interval;
    boolean aimTime, drawAim;
    JButton pauseButton;
    int score;
    PanelTimer panelTimer;
//    Timer jon;
//    int cnt;
    int nowNum = 1, ballsDone = 0, ballToAdd = 1;
    boolean firstBall = true;
    int powerStartTime, speedStartTime, dizzinessCounter;
    boolean powerStart = false, speedStart = false;
    public GamePanel(JFrame frame, Level level, Color ballColor) {
//        jon = new Timer(500, new ActionListener() {
//            public static int num = 0;
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("jon");
//                num++;
//                if (num == 2) jon.stop();
//            }
//        });
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

        interval = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!aimTime) {
                    if (nowNum < ballNumbers) nowNum++;
                }
            }
        });
        timer = new Timer(500, this);
        panelTimer = new PanelTimer();

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
                    panelTimer.Stop();
                    drawAim = false;
                    repaint();
                }
                else {
                    pauseButton.setText("Pause");
                    timer.start();
                    panelTimer.Start();
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
        interval.start();
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
        if (aimTime && SettingPanel.aimOn && drawAim && mouseYPos > 55 && mouseYPos <= 870 && mouseXPos > 0 && mouseXPos < 699) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(ballColor);
            float[] dashPattern = {10, 5};
            BasicStroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dashPattern, 0.0f);
            g2d.setStroke(dashed);
            g2d.drawLine(ballXPosition + 12, 890, mouseXPos, mouseYPos);
        }

        // draw timer and score
        g.setColor(new Color(255, 224, 0));
        g.setFont(new Font("akashi", Font.BOLD, 17));
        g.drawString(panelTimer.toString(), 625, 40);
        g.drawString("Score: " + Integer.valueOf(score).toString(), 300, 40);
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
//                System.out.println(nowNum + " " + ptr.getX() + " " + ptr.getY());
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
        for (Brick ptr : brickArrayList) {
            if (ptr.getyBegin() + ptr.getHeight() >= panelHeight) {
                frame.setContentPane(new FinishingPanel(frame));
                frame.pack();
                frame.revalidate();
                frame.repaint();
            }
        }
        // removing items out of bound
        int reg_ptr = 0;
        while (reg_ptr < regularItems.size()) {
            RegularItem item = regularItems.get(reg_ptr);
            if (item.getY() + item.getHeight() >= panelHeight) {
                regularItems.remove(item);
            }
            else reg_ptr++;
        }
    }
    public void SetVelocities(int dx, int dy) {
        int xVel = 1, yVel = -1;
//        if (Math.abs(dx) > Math.abs(dy)) {
//            yVel = -1;
//            xVel = Math.abs(dx / dy);
//            if (dx < 0) xVel = -1 * xVel;
//        }
//        else {
//            if (dx < 0) xVel = -1;
//            else xVel = 1;
//            yVel = -1 * Math.abs(dy / dx);
//        }
//
//        System.out.println(xVel + " " + yVel);

        for (Ball ptr : ballArrayList) {
            ptr.setxVelocity(xVel);
            ptr.setyVelocity(yVel);
        }
    }
    public void InitiateNextLine() {
        for (Brick brick : brickArrayList) {
            brick.setyBegin(brick.getyBegin() + 55);
        }
        for (RegularItem item : regularItems) {
            item.setY(item.getY() + 55);
        }
        BricksAndItemsInitial();

        AddBall(ballToAdd);
        for (Ball ball : ballArrayList) {
            ball.setCanMove(true);
            ball.setX(ballXPosition);
        }

        nowNum = 1;
        ballsDone = 0;
        firstBall = true;
        ballToAdd = 1;

        aimTime = true;
        timer.setDelay(500);
        repaint();
        timer.start();
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
                    if (dizzinessCounter == 0) {
                        mouseXPos = e.getX();
                        mouseYPos = e.getY();
                    }
                    else {
                        mouseXPos = GameRandomHelper.RandomMouseX();
                        mouseYPos = GameRandomHelper.RandomMouseY();
                        dizzinessCounter--;
                    }
                    repaint();
                }
            });
            this.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    aimTime = false;
                    SetVelocities(mouseXPos - ballXPosition, mouseYPos - 875);
                    timer.setDelay(10);
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
//            cnt++;
//            System.out.println("salam");
//            if (cnt == 2) {
//                jon.start();
//            }
            if (speedStart && panelTimer.getSeconds() + 15 == speedStartTime) {
                speedStart = false;
                timer.setDelay(10);
            }
            if (powerStart && panelTimer.getSeconds() + 15 == powerStartTime) {
                powerStart = false;
            }
            for (int i = 0; i < nowNum; i++) {
                Ball now = ballArrayList.get(i);
                if (!now.isCanMove()) continue;
                Rectangle ballRect = new Rectangle(now.getX(), now.getY(), now.getWidth(), now.getHeight());

                int brick_ptr = 0;
                while (brick_ptr < brickArrayList.size()) {
                    Brick brick = brickArrayList.get(brick_ptr);
                    Rectangle brickRect = new Rectangle(brick.getxBegin(), brick.getyBegin(), brick.getWidth(), brick.getHeight());

                    if (ballRect.intersects(brickRect)) {
                        if (ballRect.x + ballRect.width - 1 <= brickRect.x || ballRect.x + 1 >= brickRect.x + brickRect.width) {
                            now.setxVelocity(-1 * now.getxVelocity());
                        } else {
                            now.setyVelocity(-1 * now.getyVelocity());
                        }

                        if (powerStart) brick.setValue(brick.getValue() - 2);
                        else brick.setValue(brick.getValue() - 1);
                        if (brick.getValue() <= 0) {
                            score += (brick.getFixedValue() - (panelTimer.getSeconds() / 10));
                            brickArrayList.remove(brick);
                            // halat haye mokhtalef
                        }
                        else brick_ptr++;
                    }
                    else brick_ptr++;
                }

                int reg_ptr = 0;
                while (reg_ptr < regularItems.size()) {
                    RegularItem item = regularItems.get(reg_ptr);
                    Rectangle itemRect = new Rectangle(item.getX(), item.getY(), item.getWidth(), item.getHeight());

                    if (ballRect.intersects(itemRect)) {
                        regularItems.remove(item);
                        // halat haye mokhtalef
                        if (item.getItemType().equals(ItemType.ADD_BALL)) ballToAdd++;
                        else if (item.getItemType().equals(ItemType.SPEED_UP)) {
                            speedStart = true;
                            speedStartTime = panelTimer.getSeconds();
                            timer.setDelay(5);
                        }
                        else if (item.getItemType().equals(ItemType.POWER_UP)) {
                            powerStart = true;
                            powerStartTime = panelTimer.getSeconds();
                        }
                        else if (item.getItemType().equals(ItemType.DIZZINESS)) {
                            dizzinessCounter++;
                        }
                    }
                    else reg_ptr++;
                }

                now.setX(now.getX() + now.getxVelocity());
                now.setY(now.getY() + now.getyVelocity());
                if (now.getX() <= 0) now.setxVelocity(-1 * now.getxVelocity());
                if (now.getY() <= 55) now.setyVelocity(-1 * now.getyVelocity());
                if (now.getX() >= panelWidth - 25) now.setxVelocity(-1 * now.getxVelocity());
                if (now.getY() >= 875) {
                    ballsDone++;
                    if (firstBall) {
                        ballXPosition = now.getX();
                        firstBall = false;
                    }
                    now.setY(875);
                    now.setCanMove(false);
                }
                repaint();
            }

            if (ballsDone == ballNumbers) {
                timer.stop();
                InitiateNextLine();
            }
        }
    }
}
