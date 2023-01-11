import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class OrderFromJSONFile extends Order{
    private String order;
    private ArrayList<String> orderArr = new ArrayList<>();
    private String input;
    private JSONArray ordersList;
    private JSONParser jsonParser = new JSONParser();
    private Object obj;

    OrderFromJSONFile(){

        System.out.println("Enter absolute path to the file:");
        input = setInput();

        int count = 0;
        File file = new File(input);
        if(!file.exists() || file.length() <= 2){
            super.setOrder("");
        }

        try(FileReader reader = new FileReader(input)){
            obj = jsonParser.parse(reader);
            ordersList = (JSONArray) obj;
            count = ordersList.size();

            for (int i = 0; i < count; i++){
                // outputting objects from array
                JSONObject objJSON = (JSONObject) ordersList.get(i);
                orderArr.add((String) objJSON.get("order"));

            }

        } catch (Exception e) {
            System.out.println("Invalid input.");
            super.setOrder("");
        }

        if (count > 0){
            System.out.println("Choose number of order from 1 till " + count + ":");
            Scanner sc = new Scanner(System.in);
            try {
                int numberOfOrder = sc.nextInt();
                setOrder(orderArr.get(numberOfOrder - 1));
                order = super.getOrder();
            } catch (InputMismatchException i) {
                System.out.println("Invalid input..");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
