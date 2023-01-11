import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import java.io.FileInputStream;

public class CheckRunner {
    public static Scanner in;
    public static void main(String[] args) throws SQLException, IOException {

        System.out.println("Hello!\nTo create new check enter - new" +
                "\nTo exit enter - exit." +
                "\nTo review all available commands enter - help.");
        in = new Scanner(System.in);
        StringParser stringParser = new StringParser();
        String command, data;
        int card = 0;
        int [] cardArr = new int [2];
        while (true) {
            System.out.println("Enter command\n(new/exit/help):");

            command = in.nextLine();
            switch (command) {
                case "new": try {
                    System.out.println("Enter way of data input\n(auto/txt/json/console):");
                    Order order = new OrderCreator().createOrder(in.nextLine());
                    if (order.getOrder().length()<3){
                        break;
                    }
                    System.out.println("Your input is:\n" + order.getOrder());
                    stringParser.run(order.getOrder());
                } catch (NullPointerException e){
                    System.out.println("Unknown command!");
                    break;
                }
                    VerifyCard verifyCard = new VerifyCard(stringParser.getCard());
                    CheckLayout layout = new CheckLayout();
                    System.out.print(layout.getCheckHeader());
                    System.out.print(layout.getCardLine(verifyCard.getCardInfo()));
                    System.out.print(layout.getTableHeader());
                    double totalDiscount = 0;
                    double totalSum = 0;
                    double discount = 0;
                    for (int i = 0; i < stringParser.getProducts().size(); i+=2){
                        int productId = stringParser.getProducts().get(i);
                        int amountInCheck = stringParser.totalAmountOfIchPosition().get(productId);
                        Product product = new VerifyProduct(productId, amountInCheck).getProduct();
                        if (product != null){
                            DiscountCalculator calculator = new DiscountCalculator(verifyCard.getCardInfo()[1]);
                            discount = calculator.calculate(product);
                            totalDiscount += discount;
                            totalSum += product.getPrice();
                            System.out.print(layout.getCheckLine(stringParser.getProducts().get(i + 1), product.getProductName(), product.getPrice(), discount));
                            if (discount != 0) {
                                System.out.print(layout.getCardDiscountLine("", discount));
                            }

                        }

                    }
                    System.out.println(layout.getCheckEnding(totalDiscount, totalSum));
                    break;
                case "help":
                    FileInputStream fileInputStream = new FileInputStream("C:\\Users\\admin\\IdeaProjects\\CheckGenerator\\src\\help.txt");
                    int i;
                    while ((i = fileInputStream.read()) != -1) {
                        System.out.print((char) i);
                    }
                    break;
                case "exit":
                    in.close();
                    return;
                default:
                    System.out.println("Unknown command");
                    break;
            }
        }
    }
}
