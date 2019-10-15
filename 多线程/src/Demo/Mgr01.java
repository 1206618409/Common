package Demo;

public enum Mgr01 {
    INSTANCE;
    public void m(){}

    public static void main(String[] args) {
        for (int i = 0; i <200 ; i++) {
           new Thread(()->{
               System.out.println(Mgr01.INSTANCE.hashCode());
           }).start();
        }
    }
}
