import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

import static java.awt.Color.*;

public class Window extends JPanel implements ActionListener {

    Timer timer;
    LocalDateTime dateTime;

    public Window(){
        this.setPreferredSize(new Dimension(400, 400));
        this.setBackground(new Color(0, 0, 0, 255));
        this.setFocusable(true);
        timer = new Timer(0, this);
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
        g.setColor(white);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(3));
        g.drawOval(20, 20, 360, 360);

        for(int i = 0; i < 12; i++){
            double v = (360 * i / 12f) * (Math.PI / 180);
            double cos = Math.cos(v);
            double sin = Math.sin(v);
            g.drawLine((int) (200 + cos * 140), (int) (200 + sin * 140), (int) (200 + cos * 179), (int) (200 + sin * 179));
        }

        for(int i = 0; i < 60; i++){
            double v = (360 * i / 60f) * (Math.PI / 180);
            double cos = Math.cos(v);
            double sin = Math.sin(v);
            g.drawLine((int) (200 + cos * 160), (int) (200 + sin * 160), (int) (200 + cos * 179), (int) (200 + sin * 179));
        }

        dateTime = LocalDateTime.now();
        double dateHour = LocalDateTime.now().getHour();
        String[] times = dateTime.toString().split(":");

        double sangle = 450 - ((Double.parseDouble(times[2]) / 60f) * 360);
        double mangle = 450 - (((double) (Integer.parseInt(times[1]) / 60f) + (Double.parseDouble(times[2]) / 3600f)) * 360);
        double hangle = 450 - (((dateHour / 12f) + (Double.parseDouble(times[1]) / 720f)) * 360);
        int slength = 100;
        int mlength = 130;
        int hlength = 90;

        g.drawLine(200, 200, (int) (200 + Math.cos(mangle * (Math.PI/180)) * mlength), (int) (200 - Math.sin(mangle * (Math.PI/180)) * mlength));
        g.drawLine(200, 200, (int) (200 + Math.cos(hangle * (Math.PI/180)) * hlength), (int) (200 - Math.sin(hangle * (Math.PI/180)) * hlength));

        g.setColor(red);
        g.drawLine(200, 200, (int) (200 + Math.cos(sangle * (Math.PI/180)) * slength), (int) (200 - Math.sin(sangle * (Math.PI/180)) * slength));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}