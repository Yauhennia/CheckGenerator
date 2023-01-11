public class DiscountPromotion implements Discount{
    private Discount next;
    int cardDisc;
    public DiscountPromotion (int cardDisc){
        this.cardDisc = cardDisc;
    }


    @Override
    public double applyDiscount(Product product) {

        if(product.isProductAction() && cardDisc < PROMOTION_DISCOUNT && product.getAmountInCheck() >= AMOUNT_IN_CHECK) {

            return product.getPrice()*PROMOTION_DISCOUNT/100;

        } else {
            return next.applyDiscount(product);
        }
    }

    @Override
    public void callNext(Discount next) {
        this.next = next;
    }

    @Override
    public String getDescription() {
        return "promotion";
    }
}
