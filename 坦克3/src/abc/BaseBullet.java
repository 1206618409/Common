package abc;

import java.awt.*;

public abstract class BaseBullet {
    public static final int WIDTH =  ResourceMgr.goodTankU.getWidth();;
    public static final int HEIGHT =  ResourceMgr.goodTankU.getHeight();;
    public TankFrame tf;
    public abstract void paint(Graphics g);
    public abstract void collideWith(BaseTank tank);
}
