package homeworks.homework07;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Product> products = new ArrayList<>();

        // Пример данных для продуктов, которые можно вводить через строку
        String productData = "Хлеб,40;Молоко,60;Торт,1000;Кофе растворимый,879;Масло,150;Мороженое,200;Скидочный Торт,800,200,2023-12-31;Скидка на Кофе,500,50,2023-11-30;Скидочный Продукт%,300,30,2023-10-01";

        // Разделяем данные на отдельные продукты
        String[] productEntries = productData.split(";");

        // Создание продуктов из строк
        for (String data : productEntries) {
            String[] parts = data.split(",");
            try {
                // Проверяем наличие символа '%' в названии
                if (parts.length == 2) {
                    String name = parts[0];
                    double price = Double.parseDouble(parts[1]);
                    products.add(new Product(name, price));
                } else if (parts.length == 4 && parts[0].contains("%")) {
                    String name = parts[0];
                    double price = Double.parseDouble(parts[1]);
                    double discount = Double.parseDouble(parts[2]);
                    LocalDate expiryDate = LocalDate.parse(parts[3]);
                    products.add(new DiscountProduct(name, price, discount, expiryDate));
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка при создании продукта: " + e.getMessage());
            }
        }

        // Пример создания покупателя
        System.out.print("Введите имя покупателя и количество денег (например, 'Иван,1000'): ");
        String buyerInput = scanner.nextLine();
        String[] buyerParts = buyerInput.split(",");
        Person buyer = null;

        try {
            String buyerName = buyerParts[0];
            double buyerMoney = Double.parseDouble(buyerParts[1]);
            buyer = new Person(buyerName, buyerMoney);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании покупателя: " + e.getMessage());
            return;
        }

        // Пример покупок
        for (Product product : products) {
            buyer.buyProduct(product);
        }

        // Вывод оставшихся средств покупателя
        System.out.println(buyer);
    }
}
