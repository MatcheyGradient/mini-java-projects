package netdraw;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static java.awt.Color.black;

public class Window extends JPanel implements ActionListener {

    Timer timer;

    public Window(){
        this.setPreferredSize(new Dimension(900, 900));
        this.setBackground(new Color(255, 228, 186, 255));
        this.addMouseMotionListener(new MouseTracker());
        this.setFocusable(true);
        timer = new Timer(1, this);
        start();
    }

    public void start() {
        timer.start();
    }

    public void paint(Graphics g) {
        super.paint(g);
        draw(g);
    }

    public void draw(Graphics g){
        g.setColor(black);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(3));

        DotManager.dots.forEach(dot -> g.fillOval(dot.x - 6, dot.y - 6, 12, 12));

        DotManager.getClosestDots();
        DotManager.dotMap.forEach((dist, dot) -> {
            g.setColor(new Color(0, 0, 0, DotManager.getOpacity(dist)));
            g.drawLine(dot.x, dot.y, MouseTracker.mx, MouseTracker.my);
        });

        DotManager.dots.forEach(dot -> DotManager.dots.forEach(dot2 -> {
            if(Math.abs(dot.x - dot2.x) < 200 && Math.abs(dot.y - dot2.y) < 200){
                double dist = Math.hypot(dot.x - dot2.x, dot.y - dot2.y);
                if(dist < 200){
                    g.setColor(new Color(0, 0, 0, DotManager.getOpacity(dist) / 2));
                    g.drawLine(dot.x, dot.y, dot2.x, dot2.y);
                }
            }
        }));

        DotManager.dotMap.clear();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        DotManager.moveDots();
    }
}