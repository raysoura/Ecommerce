package service.impl;

import models.Buyer;
import repository.BuyerRepository;
import service.BuyerService;

import java.util.List;
import java.util.Optional;

public class BuyerServiceImpl implements BuyerService {
    private final BuyerRepository buyerRepository;

    public BuyerServiceImpl(BuyerRepository buyerRepository) {
        this.buyerRepository = buyerRepository;
    }
    public void addBuyer(String name, String address, String email, String pincode) {
        buyerRepository.addBuyer(name, address, email, pincode);
    }

    @Override
    public List<Buyer> getBuyerList() {
        return buyerRepository.getAllBuyers();
    }

    @Override
    public Buyer getBuyer(String buyerName) {
        return buyerRepository.getBuyer(Optional.of(buyerName));
    }
}
