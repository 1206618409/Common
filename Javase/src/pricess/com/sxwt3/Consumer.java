package pricess.com.sxwt3;

/**
 * @author ZHJ
 * @description @ZHJ
 * @create 2019-11-08 13:57
 **/
public class Consumer implements Runnable {
    private Goods goods;
    @Override
    public void run() {
        for (int i = 0; i <10 ; i++) {
            goods.get();
        }
    }

    public Consumer(Goods goods) {
        this.goods = goods;
    }
}


