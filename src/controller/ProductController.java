package controller;

import constants.PaymentMode;
import models.Product;
import service.PincodeServiceability;
import service.ProductService;

import java.util.List;

public class ProductController {
    private final ProductService productService;
    private final PincodeServiceability pincodeServiceability;

    public ProductController(ProductService productService, PincodeServiceability pincodeServiceability) {
        this.productService = productService;
        this.pincodeServiceability = pincodeServiceability;
    }

    public void addProduct(String name, String description, int quantity, String pincode) {
        productService.addProduct(name, description, quantity, pincode);
    }

    public Product getProduct(String productId) {
        return productService.getProduct(productId);
    }

    public List<Product> getProductList() {
        return productService.getProductList();
    }

    public void addPincodeServiceablity(String product, String source, String destination, PaymentMode mode) {
        pincodeServiceability.addServiceability(product, source, destination, mode);
    }
}
