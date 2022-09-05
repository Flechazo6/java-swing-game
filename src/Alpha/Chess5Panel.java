package Alpha;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

public class Chess5Panel extends JPanel implements MouseListener {
    /**
     *
     */
    private static final long serialVersionUID = -6541575403701019141L;
    int[] result = new int[2];
    int data[][] = new int[9][9]; // 1为黑子 2为白子
    boolean player = true; // 是否是人先手
    private int x0 = 30, y0 = 50; // 棋盘左上角的位置
    private int N = 9; // N*N的棋盘
    private int k = 60; // 方格宽（高）度
    private int r = 20; // 棋子（圆）半径

    public Chess5Panel() {
        addMouseListener(this);
        initBoard();
        this.setSize(600, 620);
    }

    public void initBoard() {// 遍历
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                data[i][j] = 0;
    }

    // 画棋盘
    @Override
    protected void paintComponent(Graphics g) {
        for (int i = 0; i <= N; i++) {
            g.drawLine(x0, y0 + i * k, x0 + N * k, y0 + i * k);
        }
        for (int i = 0; i <= N; i++) {
            g.drawLine(x0 + i * k, y0, x0 + i * k, y0 + N * k);
        }
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++) {
                if (data[i][j] == 1) {
                    g.setColor(Color.BLACK);
                    g.fillOval(x0 + i * k - r, y0 + j * k - r, 2 * r, 2 * r);
                    repaint();
                }
                if (data[i][j] == 2) {
                    g.setColor(Color.WHITE);
                    g.fillOval(x0 + i * k - r, y0 + j * k - r, 2 * r, 2 * r);
                    repaint();
                }
            }
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

        int x = Math.round((e.getX() - x0) / (k + 0.0f));
        int y = Math.round((e.getY() - y0) / (k + 0.0f));
//		System.out.println(x + "," + y);
        if (x < 0 || x > 8 || y < 0 || y > 8)
            return;
        if (data[x][y] == 0) {
            if (player) {
                data[x][y] = 1;
            }
            player = !player;
        }
        repaint();

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Alpha alpha = new Alpha();
        int[] point = alpha.getPoint(data);
        int x = point[0];
        int y = point[1];
        data[x][y] = 2;
        player = !player;
        repaint();

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public void save() {
        Chess5IO.writeData(data);
        repaint();
    }

    public void Clear() {
        data = new int[N + 1][N + 1];
        Chess5IO.readData();
        repaint();

    }
}

