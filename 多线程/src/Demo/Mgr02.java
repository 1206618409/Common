package Demo;

public class Mgr02 {
    private static final Mgr02 INSTANCE = new Mgr02();
    private Mgr02(){};
    public static Mgr02 getInstance(){
        return INSTANCE;
    }
    public void m(){
        System.out.println("m");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 200; i++) {
            /*new Thread(()->{
                System.out.println(Mgr01.INSTANCE.hashCode());
            }).start();*/
            Mgr02 m1 = Mgr02.getInstance();
            Mgr02 m2 =  Mgr02.getInstance();
            System.out.println(m1 == m2);
        }
    }
}
