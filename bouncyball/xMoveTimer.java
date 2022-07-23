import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class xMoveTimer { // too many timers lol

    public static int delay = 1;

    public static class xMovement implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Ball.moveBallX();
        }
    }
}
