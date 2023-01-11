import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class VerifyCard {
    private  int [] cardInfo = {0, 0};
    private int card;
    public VerifyCard(int card) throws SQLException {
        this.card = card;
        Connection conn = new ConnectionToDB().connect();
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery("SELECT card_id, total_purchase FROM card");
        int marker = 0;
        while (result.next() && marker == 0) {
            if (card == result.getInt("card_id")) {
                cardInfo[0] = card;
                if (result.getDouble("total_purchase") >= 100 && result.getDouble("total_purchase") < 500) {
                    cardInfo[1] = 3;
                    marker = 1;
                } else if (result.getDouble("total_purchase") >= 500 && result.getDouble("total_purchase") < 1000) {
                    cardInfo[1] = 5;
                    marker = 1;
                } else if (result.getDouble("total_purchase") >= 1000 && result.getDouble("total_purchase") < 5000) {
                    cardInfo[1] = 7;
                    marker = 1;
                } else if (result.getDouble("total_purchase") >= 5000) {
                    cardInfo[1] = 12;
                    marker = 1;
                }

            }

        }

    }

    public int [] getCardInfo(){

        return this.cardInfo;
    }
}
