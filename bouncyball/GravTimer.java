import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GravTimer {
    public static class GravityTimer implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Ball.ballAccelerationY();
            Ball.slowX();
        }
    }
}
