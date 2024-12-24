package homeworks.homework06.java;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Название продукта не может быть пустым");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Стоимость продукта не может быть отрицательной");
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
        return name + " (Цена: " + price + " рублей)";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Product product = (Product) obj;
        return Double.compare(product.price, price) == 0 && name.equals(product.name);
    }

    @Override
    public int hashCode() {
        return 31 * name.hashCode() + Double.hashCode(price);
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
        products.add(new Product("Торт", 1000));
        products.add(new Product("Кофе растворимый", 879));
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
    }
}
