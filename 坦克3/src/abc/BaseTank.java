package abc;

import java.awt.*;

public abstract class BaseTank {
    public static final int HEIGHT = ResourceMgr.goodTankU.getWidth();
    public static final int WIDTH = ResourceMgr.goodTankU.getHeight();
    DefaultFireStrategy df;
    public Group group = Group.BAD;
    public static Rectangle rect = new Rectangle();
    public Dir dir;
    public TankFrame tf;

    public abstract void paint(Graphics g);
    public  Group getGroup(){
        return this.group;
    }
    public abstract int getX();
    public abstract int getY();
    public abstract void die();
    public abstract Group getGroup(Group group);

}
