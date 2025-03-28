package repository;

import constants.PaymentMode;
import models.Order;
import utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderRespository {
    Map<String, Order> orderMap;

    public OrderRespository() {
        this.orderMap = new HashMap<>();
    }
    public String createOrder(String productId, String buyerId, int quantity, PaymentMode paymentMode) {
        String orderId = Utils.generateId();
        Order order = new Order(orderId, productId, quantity, paymentMode, buyerId);
        orderMap.put(orderId, order);
        return orderId;
    }

    public List<Order> geOrderList() {
        List<Order> orderList = new ArrayList<>();
        for(Order order: orderMap.values()) {
            orderList.add(order);
        }
        return orderList;
    }

    public Order geOrder(String orderId) {
        return orderMap.get(orderId);
    }
}
