package Model;

public class Student extends Client {
    private static Double discount;

    static {
        discount = 25.0;
    }

    public Student() {
    }

    public Student(String name) {
        super(name);
    }

    public Double getDiscount() {
        return discount;
    }


    @Override
    public Double getPrice(Event event){
        Double newPrice = event.getPrice() * (1 -  discount / 100);
        return newPrice;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }

}
