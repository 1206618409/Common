package zhj;
public class FourDirFireStraregy implements FireStrategy {

    public void fire(Tank tank) {
        int bx = tank.getX()+ Tank.WIDTH /2 - Bullet.WIDTH/2;
        int by = tank.getY()+ Tank.HEIGHT/2 - Bullet.HEIGHT/2;
        Dir[] dirs = Dir.values();
        for (Dir dir : dirs) {
            tank.tf.bullets.add(new Bullet(bx, by, dir, tank.group, tank.tf));
        }
        //if(tank.group == Group.GROUP) new Thread(()->new Audio("audio/mzh.wav").play());
    }

}
