import java.util.ArrayList;
import java.util.HashMap;

public class StringParser {
    private static int card;
    private static ArrayList <Integer> products = new ArrayList<>();
    private static HashMap <Integer, Integer> totalAmountOfIchPosition = new HashMap<>();

    public void run(String data){
        card = 0;
        String[] temporary = data.split(" ");
        int count  = 0;
        for (int i = 0; i < temporary.length; i ++) {
            String[] value = temporary[i].split("-");
            if (value.length < 1){
                System.out.println(temporary[i] + " - invalid!");
            }
            else if (value[0].equals("card") && count == 0) {
                try {
                    card = Integer.parseInt(value[1]);
                    count = 1;
                } catch (NumberFormatException e) {
                    System.out.println(value[1] + " - invalid!");
                }
            }
            else {
                try {
                    int product = Integer.parseInt(value[0]);
                    int quantity = Integer.parseInt(value[1]);
                    products.add(product);
                    products.add(quantity);
                    if (totalAmountOfIchPosition.containsKey(product)) {
                        totalAmountOfIchPosition.put(product, (totalAmountOfIchPosition.get(product)+quantity));
                    }
                    else {
                        totalAmountOfIchPosition.put(product, quantity);
                    }
                } catch (NumberFormatException e) {
                    System.out.println(temporary[i] + " - invalid!");

                } catch (ArrayIndexOutOfBoundsException e){

                }
            }
        }
    }


    public int getCard() {
        return card;
    }

    public ArrayList<Integer> getProducts() {
        return products;
    }

    public HashMap<Integer, Integer> totalAmountOfIchPosition() {
        return totalAmountOfIchPosition;
    }




}
