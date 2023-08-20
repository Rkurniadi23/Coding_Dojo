class Bat extends Mammal {

    public Bat(int energy){
        super(energy);
    }

    public void fly(){
        System.out.printf("Bat is airborne");
        energy -= 50 ;
    }

    public void eatHumans(){
        System.out.println("Bat is satisfied");
        energy += 25;
    }

    public void attackTown(){
        System.out.println("Incoming Bat attack!");
        energy -= 100;
    }
}