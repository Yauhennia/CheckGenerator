public class OrderCreator {
    public Order createOrder(String type) {
        Order order = null;

        if (type.equals("auto")) {
            order = new Order();
        } else if (type.equals("txt")) {
            order = new OrderFromTxtFile();
        } else if (type.equals("json")) {
            order = new OrderFromJSONFile();
        } else if (type.equals("console")) {
            order = new OrderFromConsole();
        }
        return order;
    }
}
