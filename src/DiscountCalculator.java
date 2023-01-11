public class DiscountCalculator {
    private int cardDisc;
    public DiscountCalculator (int cardDisc){
        this.cardDisc = cardDisc;
    }
    public double calculate(Product product){
        Discount d1 = new DiscountCard(cardDisc);
        Discount d2 = new DiscountPromotion(cardDisc);
        Discount d3 = new WithoutDiscount();

        d1.callNext(d2);
        d2.callNext(d3);

        return d1.applyDiscount(product);
    }
}
