import java.util.ArrayList;
import java.util.Random;

public class TestPuzzle {
    
    public static void main(String[] args) {
        
        PuzzleJava generateRandom = new PuzzleJava();

        // getTenRolls
        ArrayList<Integer> randomNum = generateRandom.getTenRolls();
        System.out.println(randomNum);

        // getRandomLetter
        System.out.println(generateRandom.getRandomLetter());
        
        // generatePassword
        System.out.println(generateRandom.generatePassword());

        // getNewPAsswordSet
        System.out.println(generateRandom.getNewPasswordSet(8)); 
    }
}
        