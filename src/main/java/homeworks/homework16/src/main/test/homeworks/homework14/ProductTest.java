package homeworks.homework14;

import homeworks.homework06.Product;

import java.util.Arrays;
import java.util.List;

class ProductService {
    public List<Product> convertStringToProduct(String line) {
        if (line == null || line.isEmpty()) {
            throw new IllegalArgumentException("Строка не должна быть пустой!");
        }

        return Arrays.stream(line.split(";"))
                .map(e -> {
                    String[] elements = e.split("=");
                    if (elements.length != 2) {
                        throw new IllegalArgumentException("Некорректный формат данных для продукта");
                    }
                    return new Product(elements[0].trim(), Double.parseDouble(elements[1].trim()));
                })
                .toList();
    }
}

