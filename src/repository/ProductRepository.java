package repository;

import models.Product;
import utils.Utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepository {
    private Map<String, Product> productMap;

    public ProductRepository() {
        this.productMap = new HashMap<>();
    }

    public Product getProduct(String productName) {
        return productMap.get(productName);
    }

    public boolean checkInventory(String productId, int orderQuantity) {
        Product product = productMap.get(productId);
        synchronized (this) {
            if (product.getQuantity() > orderQuantity) {
                product.setQuantity(product.getQuantity() - orderQuantity);
                return true;
            }
            return false;
        }

    }

    public void addProduct(String name, String description, int quantity, String pincode) {
        Product product = new Product(name, description, quantity, pincode);
        productMap.put(name, product);
    }

    public List<Product> getProductList() {
        return productMap.values().stream().toList();
    }
}
