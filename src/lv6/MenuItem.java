package lv6;

public class MenuItem {
    //속
    private String name;
    private double price;
    private String exp;
    //생
    public MenuItem(String name, double price, String exp) {
        this.name = name;
        this.price = price;
        this.exp = exp;
    }

    //기
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getExp() {
        return exp;
    }
}