public class BatTest {
    public static void main(String[] arg){
        
        Bat b = new Bat(300);
        b.attackTown();
        b.attackTown();
        b.attackTown();
        b.eatHumans();
        b.eatHumans();
        b.fly();
        b.fly();
        System.out.println(b.energy);
    }




}