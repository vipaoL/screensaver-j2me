/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screensaver;

import java.util.Random;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Graphics;

/**
 *
 * @author vipaol
 */
public class BlinkingCircles extends Canvas implements Runnable {
    
    boolean stopped = false;
    
    public BlinkingCircles() {
        setFullScreenMode(true);
    }
    
    protected void paint(Graphics g) {
        int w = getWidth();
        int h = getHeight();
        Random random = new Random();
        g.setColor(0x000000);
        //g.setColor(random.nextInt(256), random.nextInt(256), random.nextInt(256));
        g.fillRect(0, 0, w, h);
        for (int i = 0; i < 100; i++) {
            g.setColor(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            int x = 1 + random.nextInt(w - 2);
            int y = 1 + random.nextInt(h - 2);
            int maxDiam = Math.min(Math.min(x, w - x), Math.min(y, h - y)) * 2 - 1;
            int d = random.nextInt(maxDiam);
            g.setStrokeStyle(random.nextInt(2));
            if (random.nextInt(2) == 0) {
                g.fillArc(x - d / 2 - 1, y - d / 2 - 1, d, d, 0, 360);
            } else {
                g.drawArc(x - d / 2 - 1, y - d / 2 - 1, d, d, 0, 360);
            }
        }
    }

    public void run() {
        while (!stopped) {
            long startTime = System.currentTimeMillis();
            repaint();
            try {
                if (true) Thread.sleep(Math.max(0, 50 - (System.currentTimeMillis() - startTime)));
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public BlinkingCircles start() {
        (new Thread(this)).start();
        return this;
    }
    
}
