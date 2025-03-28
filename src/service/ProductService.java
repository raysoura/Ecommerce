package service;

import models.Product;

import java.util.List;

public interface ProductService {

    boolean checkInventory(String product, int orderQuantity);

    void addProduct(String name, String description, int quantity, String pincode);

    Product getProduct(String productId);

    List<Product> getProductList();
}
