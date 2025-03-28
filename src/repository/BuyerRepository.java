package repository;

import models.Buyer;
import utils.Utils;

import java.util.*;

public class BuyerRepository {
    Map<String, Buyer> buyerMap;

    public BuyerRepository() {
        this.buyerMap = new HashMap<>();
    }

    public void addBuyer(String name, String address, String email, String pincode) {
        String id = Utils.generateId();
        Buyer buyer = new Buyer(id, name, address, email, pincode);
        buyerMap.put(name, buyer);
    }

    public List<Buyer> getAllBuyers() {
        return buyerMap.values().stream().toList();
    }

    public Buyer getBuyer(Optional<String> buyerName) {
        return buyerMap.get(buyerName.get());
    }
}
