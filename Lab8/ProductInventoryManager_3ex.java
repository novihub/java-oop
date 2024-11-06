package Lab8;

import java.util.HashMap;
import java.util.Map;

public class ProductInventoryManager_3ex {
    private Map<Integer, Product> products = new HashMap<>();

    public void addProduct(int id, String name, double price) {
        products.putIfAbsent(id, new Product(id, name, price));
    }

    public void updateProduct(int id, String name, double price) {
        products.computeIfPresent(id, (k, v) -> new Product(id, name, price));
    }

    public void removeProduct(int id) {
        products.remove(id);
    }

    public void listProducts() {
        products.values().forEach(System.out::println);
    }

    public void filterByPrice(double minPrice) {
        products.values().stream()
                .filter(product -> product.price > minPrice)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        ProductInventoryManager_3ex manager = new ProductInventoryManager_3ex();
        manager.addProduct(1, "Iphone", 2345.00);
        manager.addProduct(2, "Android", 345.00);
        manager.addProduct(3, "MacBook", 12345.00);

        System.out.println("All Products:");
        manager.listProducts();

        System.out.println("\nProducts with price above 500:");
        manager.filterByPrice(500);
    }
}

class Product {
    int id;
    String name;
    double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Price: " + price;
    }
}