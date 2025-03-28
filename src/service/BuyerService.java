package service;

import models.Buyer;

import java.util.List;
import java.util.Optional;

public interface BuyerService {

    void addBuyer(String name, String address, String email, String pincode);

    List<Buyer> getBuyerList();

    Buyer getBuyer(String buyerName);
}
