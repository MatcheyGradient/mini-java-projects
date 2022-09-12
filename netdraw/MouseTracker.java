package netdraw;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseTracker implements MouseMotionListener {
    public static int mx, my;


    @Override
    public void mouseDragged(MouseEvent e) {
        mx = e.getX();
        my = e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mx = e.getX();
        my = e.getY();

    }
}
