package models;

import constants.PaymentMode;

public class AllowedDestination {
    String destination;
    public AllowedDestination(String destination, PaymentMode paymentMode) {
        this.destination = destination;
        this.paymentMode = paymentMode;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }

    PaymentMode paymentMode;
}
