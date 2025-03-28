package service;

import constants.PaymentMode;
import exception.NoInventoryException;
import exception.PincodeInserviceableException;
import models.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    String createOrder(String product, String buyer, int quantity, PaymentMode paymentMode) throws PincodeInserviceableException, NoInventoryException;

    List<Order> getOrderList();

    Order getOrder(String orderId);
}
