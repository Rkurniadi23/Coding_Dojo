import java.util.ArrayList;

public class TestOrders {
    public static void main(String[] args) {
        
        // Item name
        Items item1 = new Items();
        item1.name = "mocha";
        item1.price = 3.15;
        
        Items item2 = new Items();
        item2.name = "latte";
        item2.price = 3.00;
    
        Items item3 = new Items();
        item3.name = "drip coffee";
        item3.price = 2.50;
    
        Items item4 = new Items();
        item4.name = "cappucinno";
        item4.price = 3.00;
    
        // Order name
        Orders order1 = new Orders();
        order1.name = "Chinduri";
        System.out.println(order1);
        System.out.println(order1.total);

        Orders order2 = new Orders();
        order2.name = "Jimmy";

        Orders order3 = new Orders();
        order3.name = "Noah";

        Orders order4 = new Orders();
        order4.name = "Sam";
    
        // Application Simulations
        // Use this example code to test various orders' updates
        order2.items.add(item1);
        order2.total += item1.price;
        System.out.println(order2.total);

        order3.items.add(item4);
        order3.total += item4.price;
        System.out.println(order3.total);

        order4.items.add(item2);
        order4.total += item2.price;
        System.out.println(order4.total);

        order1.ready = true;
        System.out.println(order1.ready);

        order4.items.add(item2);
        order4.items.add(item2);
        order4.total += (item2.price * 2);
        System.out.println(order4.total);

        order2.ready = true;
        System.out.println(order2.ready);
        
        System.out.printf("Name: %s\n", order1.name);
        System.out.printf("Total: %s\n", order1.total);
        System.out.printf("Ready: %s\n", order1.ready);
    }
}
