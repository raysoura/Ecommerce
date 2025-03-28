package models;

import constants.PaymentMode;

public class Order {
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    String orderId;

    public Order(String orderId, String productName, int quantity, PaymentMode paymentMode, String userName) {
        this.orderId = orderId;
        this.productName = productName;
        this.quantity = quantity;
        this.paymentMode = paymentMode;
        this.userName = userName;
    }

    String productName;
    int quantity;
    PaymentMode paymentMode;
    String userName;

}
