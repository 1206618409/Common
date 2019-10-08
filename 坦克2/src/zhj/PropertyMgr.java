package zhj;

import java.io.IOException;
import java.util.Properties;

public class PropertyMgr {
    private static PropertyMgr PPT = new PropertyMgr();
    static Properties pro = new Properties();
    private PropertyMgr(){}
    static {

        try {
            pro.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static PropertyMgr getInstance(){
        return PPT;
    }
    public static Object get(String str){
        if (pro == null) return null;
        return pro.get(str);
    }

    public static void main(String[] args) {
        for (int i = 0; i <100 ; i++) {
            new Thread(()->{
                System.out.println(PropertyMgr.PPT.hashCode());
            }).start();
        }
    }
}