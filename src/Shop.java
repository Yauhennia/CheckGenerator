public class Shop {

    private String name = "---VV bouquet VV---";
    private String address = "volgogradskaya 5";
    public Shop() {}
    public Shop(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
