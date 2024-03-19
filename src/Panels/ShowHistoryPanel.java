package Panels;

import FileManagment.FileManager;
import Helper.CustomCellRenderer;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.text.TableView;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ShowHistoryPanel extends JPanel {

    Image image;
    public ShowHistoryPanel(JFrame frame) {
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

        String[] columnNames = {"Date", "Username", "Game Time", "Score"};
        String[][] data = FileManager.LoadGame();

        JTable table = new JTable(data, columnNames);
        table.setOpaque(false);
        table.setShowGrid(false);
        table.setEnabled(false);
        table.setDefaultRenderer(Object.class, new CustomCellRenderer());
        table.setFillsViewportHeight(true);
        table.setRowHeight(40);

        JTableHeader header = table.getTableHeader();
        header.setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JLabel label = new JLabel(value.toString());
                label.setVerticalAlignment(JLabel.CENTER);
                label.setHorizontalAlignment(JLabel.CENTER);
                label.setFont(new Font("akashi", Font.BOLD, 15));
                label.setForeground(new Color(255, 224, 0));
                label.setBackground(Color.DARK_GRAY);
                label.setOpaque(true);
                return label;
            }
        });


        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBounds(-1, 60, 703, 845);

        JScrollBar scrollBar = scrollPane.getVerticalScrollBar();
        scrollBar.setBackground(Color.DARK_GRAY);

        image = new ImageIcon("Imported things/BackGround.png").getImage();
        this.setPreferredSize(new Dimension(image.getWidth(null) - 68, image.getHeight(null) - 444));
        this.setLayout(null);

        this.add(toMain);
        this.add(scrollPane);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null);
    }
}
