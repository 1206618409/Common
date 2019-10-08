package zhj;
import java.awt.*;
import java.util.Random;

public class Tank {
    private static final int SPEED = 2;
    public static int WIDTH = ResourceMgr.goodTankU.getWidth();
    public static int HEIGHT = ResourceMgr.goodTankU.getHeight();
    private Random random = new Random();
     int x,y;
     Dir dir = Dir.DOWN;
    private boolean moving = true;
     TankFrame tf = null;
    private boolean living = true;
     Group group = Group.BAD;
     FireStrategy fs;
    public  Rectangle rect = new Rectangle();
    public Tank(int x, int y, Dir dir,Group group,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;
        rect.x = x;
        rect.y = y;
        rect.width = WIDTH;
        rect.height = HEIGHT;

        if (group == Group.GROUP) {
            String goodFSName = (String) PropertyMgr.get("goodFS");

            try {
                fs = (FireStrategy) Class.forName(goodFSName).getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            fs = new DefaultFireStrategy();
        }

    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public boolean isLiving() {
        return living;
    }

    public void setLiving(boolean living) {
        this.living = living;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Dir getDir() {
        return dir;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public void paint(Graphics g){
        if (!living) tf.tanks.remove(this);
    	switch (dir){
            case LEFT:
                g.drawImage(this.group == Group.GROUP?ResourceMgr.goodTankL:ResourceMgr.badTankL, x, y, null);
                break; 
            case UP:
                g.drawImage(this.group == Group.GROUP?ResourceMgr.goodTankU:ResourceMgr.badTankU, x, y, null);
                break;
            case RIGHT:
                g.drawImage(this.group == Group.GROUP?ResourceMgr.goodTankR:ResourceMgr.badTankR, x, y, null);
                break;
            case DOWN:
                g.drawImage(this.group == Group.GROUP?ResourceMgr.goodTankD:ResourceMgr.badTankD, x, y, null);
                break;
        }
        move();
    }
    private void move(){
        if(!moving) return;
        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case DOWN:
                y += SPEED;
                break; 
        }

        if (this.group == Group.BAD && random.nextInt(100) > 95)
            this.fire();
        if (this.group == Group.BAD && random.nextInt(100) > 95)
            randomDir();
        boundsCheck();
        //update rect
        rect.x = this.x;
        rect.y = this.y;
    }
    private void boundsCheck(){
        if (this.x < 2){
            x = 2;
        } else if (this.y < 28){
            y = 28;
        } else if (this.x >TankFrame.GAME_WIDTH -Tank.WIDTH-2){
            x = TankFrame.GAME_HEIGHT -Tank.WIDTH-2;
        } else if (this.y> TankFrame.GAME_HEIGHT - Tank.HEIGHT-2){
            y = TankFrame.GAME_HEIGHT -Tank.HEIGHT-2;
        }
    }
    private void randomDir(){
        this.dir = Dir.values()[random.nextInt(4)];
    }

    public void fire(){
        fs.fire(this);

    }
    public void die(){
        this.living = false;
    }
}
