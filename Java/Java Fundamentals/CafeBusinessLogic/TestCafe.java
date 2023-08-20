import java.util.ArrayList;
public class TestCafe {
    
    public static void main(String[] args) {
        
        CafeUtil cafeUtil = new CafeUtil();
        
        // getStreakGoal 
        int weeklyStreak = cafeUtil.getStreakGoal();
        System.out.printf("You will need %s orders to qualify for the reward.\n\n", weeklyStreak);

        // getOrderTotal
        double[] itemsPrice = {3.5, 2.4, 3.2, 3.2};
        double totalPrice = cafeUtil.getOrderTotal(itemsPrice);
        System.out.printf("Your total prices will be $%s.\n\n", totalPrice);

        // displayMenu
        ArrayList<String> menuItems = new ArrayList<String>();
        menuItems.add("drip coffee");
        menuItems.add("cappuccino");
        menuItems.add("latte");
        menuItems.add("mocha");
        cafeUtil.displayMenu(menuItems);

        // addCustomer
        ArrayList<String> customers = new ArrayList<String>();
        customers.add("Richard");
        customers.add("Max");
        customers.add("Bryant");
        customers.add("Jose");
        cafeUtil.addCustomer(customers);

        //String alexisTest = alfredBot.respondBeforeAlexis(
        //                    "Alexis! Play some low-fi beats."
        //                    );
        //String alfredTest = alfredBot.respondBeforeAlexis(
        //    "I can't find my yo-yo. Maybe Alfred will know where it is.");
        //String notRelevantTest = alfredBot.respondBeforeAlexis(
        //    "Maybe that's what Batman is about. Not winning. But failing.."
        //);
        
        // Print the greetings to test.
        
        
        // Uncomment these one at a time as you implement each method.
        //System.out.println(testGuestGreeting);
        //System.out.println(testDateAnnouncement);
        //System.out.println(alexisTest);
        //System.out.println(alfredTest);
        //System.out.println(notRelevantTest);
    }
}
