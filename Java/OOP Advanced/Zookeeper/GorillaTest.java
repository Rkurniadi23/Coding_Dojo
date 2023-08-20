public class GorillaTest {
    public static void main(String[] arg){
        
        Gorilla g = new Gorilla(100);
        g.throwSomething();
        g.throwSomething();
        g.throwSomething();
        g.eatBananas();
        g.eatBananas();
        g.climb();
        System.out.println(g.energy);
    }
}