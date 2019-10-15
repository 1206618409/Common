package abc;
public class DefaultFireStrategy implements FireStrategy {
    public void fire(BaseTank tank) {
        int bx = tank.getX()+ Tank.WIDTH /2 - Bullet.WIDTH/2;
        int by = tank.getY()+ Tank.HEIGHT/2 - Bullet.HEIGHT/2;
        new Bullet(bx,by,tank.dir,tank.group,tank.tf);
        if(tank.group == Group.GROUP) new Thread(()->new Audio("audio/mzh.wav").play()).start();
    }


}
