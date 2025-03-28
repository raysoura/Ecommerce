package service;

import constants.PaymentMode;

public interface PincodeServiceability {

    boolean checkServiceability(String product, String source, String destination, PaymentMode mode);

    void addServiceability(String product, String source, String destination, PaymentMode mode);
}
