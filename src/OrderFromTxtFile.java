import java.io.FileInputStream;


public class OrderFromTxtFile extends Order{
    private String order;
    private String input;
    OrderFromTxtFile() {

        System.out.println("Enter absolute path to the file:");
        input = setInput();
        try (FileInputStream fileInputStream = new FileInputStream(input)) {
            int i;
            while ((i = fileInputStream.read()) != -1) {
                //System.out.print((char) i);
                setOrder(order + ((char) i));
                order = super.getOrder();
            }

        } catch (Exception e) {
            System.out.println("Invalid input!");
            super.setOrder("");
        }

    }

}
