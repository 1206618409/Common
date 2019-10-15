package abc;
import java.awt.*;

public  class Bullet extends BaseBullet{
    private static final int SPEED = 10;
    public static int WIDTH = ResourceMgr.bulletL.getWidth();
    public static int HEIGHT = ResourceMgr.bulletL.getHeight();
    private int x,y;
    private Dir dir;
    private boolean living = true;
    private TankFrame tf = null;
    private Group group = Group.BAD;
    Rectangle rect = new Rectangle();
    public static int getSPEED() {
        return SPEED;
    }

    public boolean isLiving() {
        return living;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Bullet(int x, int y, Dir dir, Group group , TankFrame tf){
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
        this.group = group;
        rect.x = x;
        rect.y = y;
        rect.width = WIDTH;
        rect.height = HEIGHT;
        tf.bullets.add(this);
    }
    public void paint(Graphics g){
        if(!living){
            tf.bullets.remove(this);
        }
        switch (dir){
        case LEFT:
            g.drawImage(ResourceMgr.bulletL, x, y, null);
            break; 
        case UP:
            g.drawImage(ResourceMgr.bulletU, x, y, null);
            break;
        case RIGHT:
            g.drawImage(ResourceMgr.bulletR, x, y, null);
            break;
        case DOWN:
            g.drawImage(ResourceMgr.bulletD, x, y, null);
            break;
        }
        move();
    }
    private void move(){
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
        //update rect
        rect.x = this.x;
        rect.y = this.y;
        if(x < 0||y < 0||x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) living = false;
    }
    public void collideWith(BaseTank tank){
        if (this.group == tank.getGroup()) return;
        //用一个rect来记录子弹的位置
//        Rectangle rect1 = new Rectangle(this.x,this.y,WIDTH,HEIGHT);
//        Rectangle rect2 = new Rectangle(tank.getX(),tank.getY(),Tank.WIDTH,Tank.HEIGHT);
        if(this.rect.intersects(BaseTank.rect)){
            tank.die();
            this.die();
            int eX = tank.getX() + Tank.WIDTH /2 - Explode.WIDTH/2;
            int eY = tank.getY() + Tank.HEIGHT/2 - Explode.HEIGHT/2;
            tf.explodes.add(new Explode(eX,eY,tf));
        }

    }
    private void die(){
        this.living = false;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }
}
