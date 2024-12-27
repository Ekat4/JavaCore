package homeworks.homework08;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        if (basket.isEmpty()) {
            return name + " - Ничего не куплено";
        }
        StringBuilder result = new StringBuilder(name + " - ");
        for (Product product : basket) {
            result.append(product.getName()).append(", ");
        }
        return result.substring(0, result.length() - 2);
    }
}

public class App {
    public static void main(String[] args) {
        List<Person> customers = new ArrayList<>();
        List<Product> products = new ArrayList<>();
        List<String> outputMessages = new ArrayList<>();

        // Считывание данных из файла с использованием BufferedReader
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            // Считывание покупателей
            String line = br.readLine();
            String[] customerData = line.split("; ");
            for (String data : customerData) {
                String[] parts = data.split(" = ");
                String name = parts[0];
                double money = Double.parseDouble(parts[1]);
                customers.add(new Person(name, money));
            }

            // Считывание продуктов
            line = br.readLine();
            String[] productData = line.split("; ");
            for (String data : productData) {
                String[] parts = data.split(" = ");
                String name = parts[0];
                double price = Double.parseDouble(parts[1]);
                products.add(new Product(name, price));
            }

            // Считывание покупок
            while ((line = br.readLine()) != null) {
                if (line.equals("END")) {
                    break;
                }
                String[] parts = line.split(" ");
                String customerName = parts[0];
                String productName = parts[1];

                // Поиск покупателя и продукта
                Person customer = customers.stream()
                        .filter(c -> c.getName().equals(customerName))
                        .findFirst()
                        .orElse(null);
                Product product = products.stream()
                        .filter(p -> p.getName().equals(productName))
                        .findFirst()
                        .orElse(null);

                // Пытаемся купить продукт
                if (customer != null && product != null) {
                    boolean success = customer.buyProduct(product);
                    if (success) {
                        outputMessages.add(customerName + " купил " + productName);
                    } else {
                        outputMessages.add(customerName + " не может позволить себе " + productName);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }

        // Вывод результатов в файл
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"))) {
            for (String message : outputMessages) {
                bw.write(message);
                bw.newLine();
            }
            for (Person customer : customers) {
                bw.write(customer.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }
}

