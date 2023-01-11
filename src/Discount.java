public interface Discount {
    double applyDiscount(Product product);
    int PROMOTION_DISCOUNT = 10;
    int AMOUNT_IN_CHECK = 5;
    void callNext(Discount next);
    String getDescription();

}
