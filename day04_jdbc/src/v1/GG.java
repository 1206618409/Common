package v1;

public class GG {
    public void chase(MM mm){
        Gift g = new WarmGift(new Flower());
        give(mm,g);
    }
    public void give(MM mm,Gift g){
        System.out.println(g+"goved:");
    }

    public static void main(String[] args) {
        GG G = new GG();
        G.chase(new MM());
    }
}
