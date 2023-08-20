import java.util.ArrayList;
import java.util.Random;

public class PuzzleJava {
    
    public ArrayList<Integer> getTenRolls(){
        Random ranMachine = new Random();
        ArrayList<Integer> tenRandomNum = new ArrayList<Integer>();
        for(int i = 0; i < 10; i++){
            tenRandomNum.add(ranMachine.nextInt(20) + 1);
        }
        return tenRandomNum;
    }
    
    public String getRandomLetter(){
        Random ranMachine = new Random();
        String[] alphabetList = new String[26];
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        for(int i = 0; i < 26; i++){
            alphabetList[i] = String.valueOf(alphabet.charAt(i));
        }
        return alphabetList[ranMachine.nextInt(26)];
    }

    public String generatePassword(){
        String randPassword = "";
        for(int i = 0; i < 8; i++){
            randPassword += getRandomLetter();
        }
        return randPassword;
    }

    public ArrayList<String> getNewPasswordSet(int num){
        ArrayList<String> newPassword = new ArrayList<String>();
        for(int i = 0; i < num; i++){
            newPassword.add(generatePassword());
        }
        return newPassword;
    }
}