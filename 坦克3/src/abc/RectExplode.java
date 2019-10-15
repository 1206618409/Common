package abc;

import java.awt.*;

public class RectExplode extends BaseExplode {
    public static int WIDTH = ResourceMgr.explodes[0].getWidth();
    public static int HEIGHT = ResourceMgr.explodes[0].getHeight();
    private int x,y;

    // private boolean living = true;
    private TankFrame tf = null;
    private int step = 0;

    public RectExplode(int x, int y, TankFrame tf){
        this.x = x;
        this.y = y;
        this.tf = tf;
        new Thread(()->new Audio("audio/mzh.wav").play()).start();
    }
    @Override
    public void paint(Graphics g){
        Color c = g.getColor();
        g.setColor(Color.red);
        g.fillRect(x,y,10*step,10*step);
        step++;
        if (step>=15)
            tf.explodes.remove(this);
        g.setColor(c);
    }

}
