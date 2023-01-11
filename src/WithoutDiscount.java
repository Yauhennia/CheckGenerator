public class WithoutDiscount implements Discount{

    @Override
    public double applyDiscount(Product product) {
        return 0;
    }

    @Override
    public void callNext(Discount next) {

    }

    @Override
    public String getDescription() {
        return "no discount";
    }
}
