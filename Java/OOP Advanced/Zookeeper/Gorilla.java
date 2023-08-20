class Gorilla extends Mammal {

    public Gorilla(int energy){
        super(energy);
    }

    public void throwSomething(){
        System.out.printf("Gorilla is throwing something");
        energy -= 5 ;
    }

    public void eatBananas(){
        System.out.println("Gorilla is satisfied");
        energy += 10;
    }

    public void climb(){
        System.out.println("Gorilla has climbed a tree");
        energy -= 10;
    }
}

