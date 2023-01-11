import java.text.SimpleDateFormat;
import java.util.Date;

public class CheckLayout extends Shop{
    private SimpleDateFormat fd = new SimpleDateFormat("dd-MM-yy");
    private SimpleDateFormat ft = new SimpleDateFormat( "HH:mm:ss");
    private String strDate = fd.format(new Date());
    private String strTime = ft.format(new Date());
    private String strCashier = "7777";
    private String tableHeader = String.format("%s %s%12s%11s\n","QTY","DESCRIPTION","PRISE","TOTAL");
    public String getDate(){
        return strDate;
    }
    public String getTime(){
        return strTime;
    }

    public String UnderlineGenerator(String sample){
        String result = "";
        for (int i = 0; i <= tableHeader.length(); i++){
            result += sample;
        }
        return result + "\n";
    }

    public String getCheckHeader(){

        String receipt = String.format("%"+(tableHeader.length()/2+"RECEIPT".length()/2)+"s", "RECEIPT");
        String name = String.format("%"+(tableHeader.length()/2+getName().length()/2)+"s", getName());
        String address = String.format("%"+(tableHeader.length()/2+getAddress().length()/2)+"s", getAddress());
        String cashier = String.format("%s%s%17s%5s", "CASHIER №" , strCashier , "DATE: ",strDate);
        String time = String.format("%38s",("TIME: "+(String)strTime));
        String underLine = UnderlineGenerator("-");

        return receipt + "\n" + underLine + name + "\n" + address + "\n\n" + cashier + "\n" + time +"\n" + underLine;

    }
    public String getCardLine(int[] card) {

        String curdNumber = String.format("%" + (tableHeader.length()-7) + "s%06d\n","card     №",card[0]);
        String curdDiscount = String.format("%" + (tableHeader.length()-7) + "s%-6d\n\n","discount %",card[1]);
        return curdNumber + curdDiscount;
    }

    public String getTableHeader() {
        return tableHeader;
    }


    public String getCheckLine(int qty, String description, double price, double discountSum) {

        return String.format("%-4d%-12s%11.2f%11.2f\n",qty,description,(price),(qty*(price-discountSum)));
    }


    public String getCardDiscountLine(String type, double discount) {
        return String.format("%" + (tableHeader.length()-17) + "s %s%11.2f\n", type, "disc",discount);
    }

    public String getCheckEnding(double discTotal, double sumTotal) {

        String underLine = UnderlineGenerator("=");
        String checkTotalWithoutDisc = String.format("%-" + (tableHeader.length()-12) + "s%11.2f\n", "tot without discount", sumTotal);
        String discountTotal = String.format("%" + (tableHeader.length()-19) + "s%18.2f\n", "discount", discTotal);
        String checkTotal = String.format("%" + (tableHeader.length()-19) + "s%18.2f\n", "TOTAL", (sumTotal - discTotal));
        String thanks1 = String.format("%"+(tableHeader.length()/2+"^ ^".length()/2)+"s\n", " ^ ^");
        String thanks2 = String.format("%"+(tableHeader.length()/2+"THANKS".length()/2)+"s\n", "THANKS");
        String thanks3 = String.format("%"+(tableHeader.length()/2+"V".length()/2)+"s\n", " V");

        return "\n" + underLine + checkTotalWithoutDisc + discountTotal + "\n" + checkTotal + underLine + thanks1 + thanks2 + thanks3;
    }
}
