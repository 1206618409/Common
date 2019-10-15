package abc;

import java.awt.*;

public abstract class BaseTank {
    Group group = Group.BAD;
    public static Rectangle rect = new Rectangle();
    public abstract void paint(Graphics g);
    public  Group getGroup(){
        return this.group;
    }
    public abstract int getX();
    public abstract int getY();
    public abstract void die();


}
