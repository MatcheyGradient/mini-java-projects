import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Color.black;
import static java.awt.Color.white;

public class Window extends JPanel implements ActionListener {

    Timer timer, gravityTimer, xMove;
    Ball ball;

    public Window(){
        this.setPreferredSize(new Dimension(600, 600));
        this.setBackground(new Color(255, 227, 106, 255));
        this.setFocusable(true);
        timer = new Timer(1, this);
        gravityTimer = new Timer(100, new GravTimer.GravityTimer());
        xMove = new Timer(xMoveTimer.delay, new xMoveTimer.xMovement());
        ball = new Ball();
        start();
    }

    public void start() {
        timer.start();
        gravityTimer.start();
        xMove.start();

        //sets initial ball conditions
        Ball.ballX = 270;
        Ball.ballY = 0;
        Ball.ballVelocityY = 40;
        Ball.ballVelocityX = 20;
        Ball.yVelocityTracker = Ball.ballVelocityY;
        Ball.xVelocityTracker = Ball.ballVelocityX;
    }

    public void paint(Graphics g) {
        super.paint(g);
        draw(g);
    }

    public void draw(Graphics g){
        g.setColor(black);

        // draw "frame" of the board
        g.fillRect(0, 570, 600, 30);
        g.fillRect(0, 0, 30, 570);
        g.fillRect(570, 0, 30, 570);
        g.setColor(white);
        g.drawRect(30, -1, 540, 571);

        ball.render(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Ball.dropBallY();
        xMove.setDelay(xMoveTimer.delay);
        repaint();
    }
}
