import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class VerifyProduct {
    Product product = null;

    public VerifyProduct(int productId, int amountInCheck) throws SQLException {
        Connection conn = new ConnectionToDB().connect();
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery("SELECT product_id, product_name, price, promotion FROM product");
        while (result.next()) {
            int idInBase = result.getInt("product_id");
            if (productId == idInBase) {
                product = new Product.Builder()
                        .withProductId(productId)
                        .withProductName(result.getString("product_name"))
                        .withPrice(result.getDouble("price"))
                        .withProductAction(result.getBoolean("promotion"))
                        .withAmountInCheck(amountInCheck)
                        .build();
            }
        }
    }

    public Product getProduct(){
        return product;
    }

}

