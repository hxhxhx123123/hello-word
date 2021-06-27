package com.hx;

import com.hx.utils.Coordinate;
import com.hx.utils.DirectionEnum;
import com.hx.utils.SnakeConf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

public class Snake extends JPanel implements ActionListener {

    // 游戏是否仍在进行中
    private boolean inGame = true;
    // 贪食蛇从头到尾，每个点的坐标
    private final LinkedList<Coordinate> snakeCoordinates = new LinkedList<>();
    // 当前贪食蛇的前进方向
    private DirectionEnum direction = DirectionEnum.RIGHT;
    // 苹果的坐标
    private Coordinate appleCoordinate = new Coordinate(0, 0);

    private Timer timer;
    private Image head;
    private Image body;
    private Image apple;

    public Snake() {
        initBoard();
    }

    private void initBoard() {
        setBackground(Color.black);
        setFocusable(true);
        setPreferredSize(new Dimension(SnakeConf.B_WIDTH, SnakeConf.B_HEIGHT));
        loadImages();
        addKeyListener(new TAdapter());
        initGame();
    }

    private void loadImages() {
        ImageIcon iid = new ImageIcon("src/main/resources/dot.png");
        body = iid.getImage();
        ImageIcon iia = new ImageIcon("src/main/resources/apple.png");
        apple = iia.getImage();
        ImageIcon iih = new ImageIcon("src/main/resources/head.png");
        head = iih.getImage();
    }

    private void initGame() {
        int middle = (SnakeConf.LINE_DOTS / 2) * SnakeConf.SNAKE_UNIT_SIZE;
        for (int z = 0; z < SnakeConf.SNAKE_INIT_LENGTH; z++) {
            snakeCoordinates.add(new Coordinate(middle - z * SnakeConf.SNAKE_UNIT_SIZE, middle));
        }

        genApple();
        timer = new Timer(SnakeConf.SNAKE_DELAY, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }

    private void doDrawing(Graphics g) {
        if (inGame) {
            g.drawImage(apple, appleCoordinate.getX(), appleCoordinate.getY(), this);
            for (int z = 0; z < snakeCoordinates.size(); z++) {
                Image image = z == 0 ? head : body;
                g.drawImage(image, snakeCoordinates.get(z).getX(), snakeCoordinates.get(z).getY(), this);
            }
            Toolkit.getDefaultToolkit().sync();
        } else {
            handleGameOver(g);
        }
    }

    private void handleGameOver(Graphics g) {
        String msg = "Game Over";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = getFontMetrics(small);
        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (SnakeConf.B_WIDTH - metr.stringWidth(msg)) / 2, SnakeConf.B_HEIGHT / 2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (inGame) {
            checkApple();
            checkGameOver();
            move();
        }
        repaint();
    }

    /*
     Task3: 重头戏，吃苹果。吃到苹果，需要增加蛇身的长度，同时生成新的苹果
     提示：根据蛇倒数两个节点的坐标，在蛇尾增加一节
     预期结果：完成初版的贪食蛇游戏，可以正常游玩
     */
    private void checkApple() {

    }

    /*
     Task 2: 检查贪食蛇的游戏结束条件，游戏结束需要将inGame变量设为false
     提示：检查蛇头的坐标即可
     预期结果：如果蛇头到了边框外，或者蛇头碰到了蛇身，屏幕上会提示Game Over
     */
    private void checkGameOver() {

    }

    /*
     Task 0: 随机生成苹果
     提示：Math.random()可以生成0-1之间的随机浮点数。另外这里还需要用到SnakeConf里的常量。注意苹果的位置不要和蛇重复，重复了就重新再生成一次。
     预期结果：完成这个函数后，每次运行Hello的main方法，出现的苹果都不在一个位置
     */
    private void genApple() {

    }

    /*
     Task 1: 让贪食蛇动起来
     提示：贪食蛇的每一节向前面那节的位置移动，蛇头向direction方向移动
     预期结果：按键盘的上下左右，贪食蛇可以正常移动（甚至可以移出屏幕外再移回来）
     */
    private void move() {

    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            if ((key == KeyEvent.VK_LEFT) && (!direction.equals(DirectionEnum.RIGHT))) {
                direction = DirectionEnum.LEFT;
            }
            if ((key == KeyEvent.VK_RIGHT) && (!direction.equals(DirectionEnum.LEFT))) {
                direction = DirectionEnum.RIGHT;
            }
            if ((key == KeyEvent.VK_UP) && (!direction.equals(DirectionEnum.DOWN))) {
                direction = DirectionEnum.UP;
            }
            if ((key == KeyEvent.VK_DOWN) && (!direction.equals(DirectionEnum.UP))) {
                direction = DirectionEnum.DOWN;
            }
        }
    }
}
