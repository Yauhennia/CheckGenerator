import java.util.Scanner;

public class OrderFromConsole extends Order{

    private String order;

    OrderFromConsole(){
        System.out.println("Enter you order\n(example: 1-2 3-4 5-6 card-00005):");
        setOrder(setInput());
        order = getOrder();
    }
}
