import java.util.Scanner;

public class Order {
    private String order = "3-1 2-5 3-3 1-5 4-8 5-2 1-1 3-1 card-000005";
    private String input;

    public String setInput (){
        Scanner sc = new Scanner(System.in);
        return input = sc.nextLine();
    }
    public String getOrder() {

        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
