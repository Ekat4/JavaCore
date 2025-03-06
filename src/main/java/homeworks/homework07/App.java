package homeworks.homework07;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        if (name == null || name.trim().isEmpty() || name.matches("\\d+") || name.length() < 3) {
            throw new IllegalArgumentException("Недопустимое имя продукта!");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("Стоимость продукта должна быть положительной!");
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
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Product product = (Product) obj;
        return Double.compare(product.price, price) == 0 && name.equals(product.name);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int hashCode() {
        return 31 * name.hashCode() + Double.hashCode(price);
    }
}

class DiscountProduct extends Product {
    private double discount; // Размер скидки
    private LocalDate expirationDate; // Срок действия скидки

    public DiscountProduct(String name, double price, double discount, LocalDate expirationDate) {
        super(name, price);
        if (discount <= 0 || discount >= price) {
            throw new IllegalArgumentException("Скидка должна быть положительной и меньше цены продукта.");
        }
        this.discount = discount;
        this.expirationDate = expirationDate;
    }

    @Override
    public double getPrice() {
        if (LocalDate.now().isAfter(expirationDate)) {
            return super.getPrice(); // Возвращаем обычную цену, если срок действия скидки истек
        }
        return super.getPrice() - discount; // Возвращаем цену со скидкой
    }

    @Override
    public String toString() {
        return super.toString() + " (Скидка: " + discount + " рублей, Срок действия: " + expirationDate + ")";
    }
}

class Person {
    private String name;
    private double money;
    private List<Product> basket;

    public Person(String name, double money) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        if (money < 0) {
            throw new IllegalArgumentException("Деньги не могут быть отрицательными");
        }
        this.name = name;
        this.money = money;
        this.basket = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public double getMoney() {
        return money;
    }

    public List<Product> getBasket() {
        return basket;
    }

    public boolean buyProduct(Product product) {
        if (product.getPrice() <= money) {
            basket.add(product);
            money -= product.getPrice();
            System.out.println(name + " купил " + product.getName());
            return true;
        } else {
            System.out.println(name + " не может позволить себе " + product.getName());
            return false;
        }
    }

    @Override
    public String toString() {
        return name + (basket.isEmpty() ? " - Ничего не куплено" : " - " + basket);
    }
}

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> customers = new ArrayList<>();
        List<Product> products = new ArrayList<>();

        customers.add(new Person("Павел Андреевич", 10000));
        customers.add(new Person("Анна Петровна", 2000));
        customers.add(new Person("Борис", 10));

        products.add(new Product("Хлеб", 40));
        products.add(new Product("Молоко", 60));
        products.add(new DiscountProduct("Торт", 1000, 200, LocalDate.now().plusDays(5))); // Скидка 200
        products.add(new DiscountProduct("Кофе растворимый", 879, 432, LocalDate.now().plusDays(3))); // Скидка 432
        products.add(new Product("Масло", 150));

        // Процесс выбора продуктов
        int currentCustomerIndex = 0;

        while (true) {
            Person currentCustomer = customers.get(currentCustomerIndex);
            System.out.println(currentCustomer.getName() + ", выберите продукт (или введите 'END' для завершения):");
            for (Product product : products) {
                System.out.println(product);
            }

            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("END")) {
                break;
            }

            // Найти выбранный продукт
            boolean productFound = false;
            for (Product product : products) {
                if (product.getName().equalsIgnoreCase(input)) {
                    currentCustomer.buyProduct(product);
                    productFound = true;
                    break;
                }
            }

            if (!productFound) {
                System.out.println("Продукт не найден. Попробуйте снова.");
            }

            // Переход к следующему покупателю
            currentCustomerIndex = (currentCustomerIndex + 1) % customers.size();
        }

        // Вывод содержимого пакета для каждого покупателя
        for (Person customer : customers) {
            System.out.println(customer);
        }

        // Обработка случаев
        testAdditionalCases(scanner);
    }

    private static void testAdditionalCases(Scanner scanner) {
        // Тестовые случаи
        try {
            Person zhenya = new Person("Женя", 0);
            Product iceCream = new Product("Мороженое", 200);
            zhenya.buyProduct(iceCream);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            Person sveta = new Person("Света", -3);
            Product pasta = new Product("Макароны", 800);
            sveta.buyProduct(pasta);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Тестирование недопустимых имен и цен
        try {
            Product invalidProduct1 = new Product("88", 100);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // Недопустимое имя продукта!
        }

        try {
            Product invalidProduct2 = new Product("Т", 100);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // Недопустимое имя продукта!
        }

        try {
            Product invalidProduct3 = new Product("Шоколадка", -1);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // Стоимость продукта должна быть положительной!
        }

        try {
            DiscountProduct invalidDiscountProduct = new DiscountProduct("Чипсы", 100, 150, LocalDate.now().plusDays(5));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // Скидка должна быть положительной и меньше цены продукта.
        }
    }
}
