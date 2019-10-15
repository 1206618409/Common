package zhj;

import abc.BaseBullet;
import abc.BaseTank;
import abc.Bullet;
import abc.Dir;
import abc.FireStrategy;

public class FourDirFireStraregy implements FireStrategy {
    @Override
    public void fire(BaseTank tank) {
        int bx = tank.getX() + BaseTank.WIDTH / 2 - BaseBullet.WIDTH / 2;
        int by = tank.getY() + BaseTank.HEIGHT / 2 - BaseBullet.HEIGHT / 2;
        Dir[] dirs = Dir.values();
        for (Dir dir : dirs) {
            tank.tf.bullets.add(new Bullet(bx, by, dir, tank.group, tank.tf));
            //new new BaseBullet(bx,by,dir, tank.getGroup(),tank.tf);
        }
        //if(tank.group == Group.GROUP) new Thread(()->new Audio("audio/mzh.wav").play());
    }
}
