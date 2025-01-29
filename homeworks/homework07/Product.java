package homeworks.homework07;
public class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        if (name == null || name.trim().isEmpty() || name.matches("\\d+")) {
            throw new IllegalArgumentException("Название продукта должно быть непустым и не может содержать только цифры.");
        }
        if (name.length() < 3) {
            throw new IllegalArgumentException("Название продукта должно содержать не менее 3 символов.");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("Стоимость продукта должна быть положительным числом.");
        }
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " - " + price + " рублей";
    }
}

