package homeworks.homework07;

import java.util.ArrayList;
import java.util.List;
public class Person {
    private String name;
    private double money;

    public Person(String name, double money) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя покупателя не может быть пустым.");
        }
        if (money < 0) {
            throw new IllegalArgumentException("Количество денег не может быть отрицательным.");
        }
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public double getMoney() {
        return money;
    }

    public boolean buyProduct(homeworks.homework07.Product product) {
        double price = (product instanceof DiscountProduct) ? ((DiscountProduct) product).getDiscountedPrice() : product.getPrice();
        if (money >= price) {
            money -= price;
            System.out.println(name + " купил " + product.getName() + " за " + price + " рублей.");
            return true;
        } else {
            System.out.println(name + " не хватает денег для покупки " + product.getName() + ".");
            return false;
        }
    }

    @Override
    public String toString() {
        return name + " имеет " + money + " рублей.";
    }
}
