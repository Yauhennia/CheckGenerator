public class Product {
    private int productId;
    private String productName;
    private double price;
    private boolean productAction;
    private int amountInCheck;

    public static class Builder{
        private Product newProduct;
        public Builder () {
            newProduct = new Product();
        }
        public Builder withProductId (int productId){
            newProduct.productId = productId;
            return  this;
        }

        public Builder withProductName (String productName){
            newProduct.productName = productName;
            return  this;
        }
        public Builder withPrice (double price){
            newProduct.price = price;
            return  this;
        }
        public Builder withProductAction (boolean productAction){
            newProduct.productAction = productAction;
            return  this;
        }
        public Builder withAmountInCheck (int withAmountInCheck){
            newProduct.amountInCheck = withAmountInCheck;
            return  this;
        }
        public Product build(){
            return newProduct;
        }

    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public boolean isProductAction() {
        return productAction;
    }

    public int getAmountInCheck() {
        return amountInCheck;
    }
}
