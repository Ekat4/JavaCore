package homeworks.homework07;
import java.time.LocalDate;

public class DiscountProduct extends Product {
    private double discount;
    private LocalDate expiryDate;

    public DiscountProduct(String name, double price, double discount, LocalDate expiryDate) {
        super(name, price);
        if (discount <= 0) {
            throw new IllegalArgumentException("Скидка должна быть положительным числом.");
        }
        this.discount = discount;
        this.expiryDate = expiryDate;
    }

    public double getDiscountedPrice() {
        if (LocalDate.now().isAfter(expiryDate)) {
            return getPrice(); // Если срок действия скидки истек, возвращаем полную цену
        }
        return getPrice() - discount;
    }

    @Override
    public String toString() {
        return super.toString() + " (Скидка: " + discount + " рублей, Действует до: " + expiryDate + ")";
    }
}
