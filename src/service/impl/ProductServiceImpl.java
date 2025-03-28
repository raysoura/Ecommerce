package service.impl;

import models.Product;
import repository.ProductRepository;
import service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public boolean checkInventory(String product, int orderQuantity) {
        return productRepository.checkInventory(product, orderQuantity);
    }

    @Override
    public void addProduct(String name, String description, int quantity, String pincode) {
        productRepository.addProduct(name, description, quantity, pincode);
    }

    @Override
    public Product getProduct(String product) {
        return productRepository.getProduct(product);
    }

    @Override
    public List<Product> getProductList() {
        return productRepository.getProductList();
    }
}
