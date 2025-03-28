package controller;

import models.Buyer;
import service.BuyerService;
import service.impl.BuyerServiceImpl;

import java.util.List;

public class BuyerController {
    private final BuyerService buyerService;

    public BuyerController(BuyerServiceImpl buyerServiceImpl) {
        this.buyerService = buyerServiceImpl;
    }

    public void addBuyer(String name, String address, String email, String pincode) {
        buyerService.addBuyer(name, address, email, pincode);
    }


    public List<Buyer> getBuyerList() {
        return buyerService.getBuyerList();
    }

    public Buyer getBuyer(String buyerName) {
        return buyerService.getBuyer(buyerName);
    }
}
