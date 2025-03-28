package service.impl;

import constants.PaymentMode;
import exception.NoInventoryException;
import exception.PincodeInserviceableException;
import models.Buyer;
import models.Order;
import models.Product;
import repository.OrderRespository;
import service.BuyerService;
import service.OrderService;
import service.PincodeServiceability;
import service.ProductService;

import java.util.List;
import java.util.Optional;

public class OrderServiceImpl implements OrderService {

    private final OrderRespository orderRespository;
    private final PincodeServiceability pincodeServiceability;

    private final BuyerService buyerService;

    private final ProductService productService;

    public OrderServiceImpl(OrderRespository orderRespository,PincodeServiceability pincodeServiceability,
                     BuyerService buyerService, ProductService productService) {
        this.orderRespository = orderRespository;
        this.pincodeServiceability = pincodeServiceability;
        this.productService = productService;
        this.buyerService = buyerService;
    }

    @Override
    public String createOrder(String productId, String buyerId, int quantity, PaymentMode paymentMode) throws PincodeInserviceableException, NoInventoryException {
        Buyer buyer = buyerService.getBuyer(buyerId);
        Product product = productService.getProduct(productId);
        if (!pincodeServiceability.checkServiceability(productId, product.getPincode(), buyer.getPincode(), paymentMode)) {
            throw new PincodeInserviceableException();
        }
        if (productService.checkInventory(productId, quantity)) {
            return orderRespository.createOrder(productId, buyerId, quantity, paymentMode);
        }
        throw new NoInventoryException();
    }

    @Override
    public List<Order> getOrderList() {
        return orderRespository.geOrderList();
    }

    @Override
    public Order getOrder(String orderId) {
        return orderRespository.geOrder(orderId);
    }

}
