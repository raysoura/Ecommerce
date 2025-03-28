package controller;

import constants.PaymentMode;
import exception.NoInventoryException;
import exception.PincodeInserviceableException;
import models.Order;
import service.OrderService;
import service.impl.OrderServiceImpl;

import java.util.List;

public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    public String createOrder(String product, String buyer, int quantity, PaymentMode paymentMode) {
        try {
            return orderService.createOrder(product, buyer, quantity, paymentMode);
        } catch (PincodeInserviceableException e) {
            System.out.println("Pincode provided is not serviceable");
        } catch (NoInventoryException e) {
            System.out.println("There is no inventory left for the product");
        }
        return null;
    }

    public List<Order> getOrderList() {
        return orderService.getOrderList();
    }

    public Order getOrder(String orderId) {
        return orderService.getOrder(orderId);
    }


}
