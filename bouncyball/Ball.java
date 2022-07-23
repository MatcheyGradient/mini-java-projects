import java.awt.*;

import static java.awt.Color.black;
import static java.awt.Color.white;

public class Ball {

    public static int ballSlowCounter;

    public static int ballVelocityX;
    public static int ballVelocityY;

    public static int yVelocityTracker;
    public static int xVelocityTracker;

    public static double ballX;
    public static double ballY;


    static boolean right = true;

    public void render(Graphics g){
        g.setColor(black);
        g.fillOval((int) ballX, (int) ballY, 30, 30);
        g.setColor(white);
        g.drawOval((int) ballX, (int) ballY, 30, 30);
    }

    public static void moveBallX(){
        if(ballVelocityX/4f + ballX > 540){
            right = false;
            slowX();
        } else if(ballX - ballVelocityX/4f < 30){
            right = true;
            slowX();
        }

        if(right){
            ballX += ballVelocityX/4f;
        } else {
            ballX -= ballVelocityX/4f;
        }

    }

    public static void dropBallY(){
        if(ballVelocityY/4f + ballY > 540){
            bounceY();
        }
        ballY += ballVelocityY/4f;
    }

    public static void ballAccelerationY(){
        ballVelocityY += 4;
    }

    public static void bounceY(){
        if(yVelocityTracker != 0){
            yVelocityTracker = (int) (yVelocityTracker - 1);
        }
        ballVelocityY = -yVelocityTracker;
    }

    public static void slowX(){
        ballSlowCounter++;

        if(ballSlowCounter == 40 && ballVelocityX != 0 && xMoveTimer.delay != 0){ // tf is this bruh
            ballSlowCounter = 0;
            xMoveTimer.delay += 2;
            ballVelocityX -= 1;
        }
    }
}
