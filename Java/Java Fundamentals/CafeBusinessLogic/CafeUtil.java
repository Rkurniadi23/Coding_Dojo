import java.util.ArrayList;
public class CafeUtil {
    
    public int getStreakGoal() {
        int sum = 0;
        int numWeek = 10;
        for(int i = 0; i <= numWeek; i++){
            sum += i;
        }
        return sum;
    }
    
    public double getOrderTotal(double[] prices) {
        double totalPrice = 0;
        for(int i = 0; i < prices.length; i++){
            totalPrice += prices[i];
        }
        return totalPrice;
    }

    public void displayMenu(ArrayList<String> menuItems){
        for(int i = 0; i < menuItems.size(); i++){
            System.out.printf("%s %s\n\n", i, menuItems.get(i));
        }
    }

    public void addCustomer(ArrayList<String> customers){
        for(int i = 0; i < customers.size(); i++){
            System.out.printf("Hello %s, there are %s people in front of you.\n\n", customers.get(i), i);
        }
    }
}

