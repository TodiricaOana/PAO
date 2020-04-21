package Model;

public class Child extends Client{
    private static Double discount;

    static {
        discount = 50.0;
    }

    public Child() {
    }

    public Child(String name) {
        super(name);
    }

    public Double getDiscount() {
        return discount;
    }

    public String getType(){
        return "Child";
    }

    @Override
    public Double getPrice(Event event) {
        Double newPrice = event.getPrice() * (1 -  discount / 100);
        return newPrice;
    }

    @Override
    public String toString() {
        return "Child{" +
                "name='" + name + '\'' +
                '}';
    }
}
