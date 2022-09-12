package netdraw;

import javax.swing.*;
import java.util.Random;

public class Main extends JFrame {

    public Main(){
        this.add(new Window());
        this.setTitle("netBg");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args){
        Random r = new Random();

        for(int i = 0; i < 50; i++){
            DotManager.dots.add(new Dot(r.nextInt(900), r.nextInt(900)));
        }

        DotManager.dots.forEach(dot -> {
            DotManager.dotX.put(dot, r.nextInt(5) - 2);
            DotManager.dotY.put(dot, r.nextInt(5) - 2);
        });

        new Main();

    }
}
