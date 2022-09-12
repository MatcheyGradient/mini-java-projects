package netdraw;

import java.util.*;

public class DotManager {
    static ArrayList<Dot> dots = new ArrayList<>();
    static HashMap<Double, Dot> dotMap = new HashMap<>();

    static HashMap<Dot, Integer> dotX = new HashMap<>();
    static HashMap<Dot, Integer> dotY = new HashMap<>();

    public static void getClosestDots(){

        dots.forEach(d -> {
            if(Math.abs(d.x - MouseTracker.mx) < 200 && Math.abs(d.y - MouseTracker.my) < 200){
                double distance = Math.hypot(d.x - MouseTracker.mx, d.y - MouseTracker.my);

                dotMap.put(distance, d);
            }
        });
    }

    public static int getOpacity(double distance) {
        double opacity = 255 - distance * (255/200f);

        if(opacity > 255 || opacity < -255){
            return 255;
        } else {
            return (int)Math.abs(opacity);
        }
    }

    public static void moveDots() {

        dots.forEach(dot -> {
            dot.x += dotX.get(dot);
            dot.y += dotY.get(dot);

            if(dot.x < 0) {
                dot.x = 900;
            }
            if(dot.x > 900) {
                dot.x = 0;
            }
            if(dot.y < 0) {
                dot.y = 900;
            }
            if(dot.y > 900) {
                dot.y = 0;
            }
        });

    }
}
