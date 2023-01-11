public class DiscountCard implements Discount {
    private Discount next;
    private int cardDisc;
    public DiscountCard (int cardDisc){
        this.cardDisc = cardDisc;
    }
    @Override
    public double applyDiscount(Product product) {

        if(cardDisc > 0 && (!product.isProductAction() || (product.isProductAction() && cardDisc > PROMOTION_DISCOUNT) || (product.getAmountInCheck() < AMOUNT_IN_CHECK))) {
            return product.getPrice()*cardDisc/100;
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
        return "card";
    }

}
