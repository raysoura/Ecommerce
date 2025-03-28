package repository;

import constants.PaymentMode;
import models.AllowedDestination;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PincodeServiceabilityRepository {
    Map<String, Map<String, List<AllowedDestination>>> map;

    public PincodeServiceabilityRepository() {
        this.map = new HashMap<>();
    }

    public boolean checkServiceability(String product, String source, String destination, PaymentMode mode) {
        Map<String, List<AllowedDestination>> serviceabilityMap = map.get(product);
        List<AllowedDestination> allowedDestinations = serviceabilityMap.get(source);
        return allowedDestinations.stream().anyMatch(allowedDestination -> allowedDestination.getDestination().equals(destination)
                && allowedDestination.getPaymentMode().equals(mode));
    }

    public void addServiceability(String product, String source, String destination, PaymentMode mode) {
        Map<String, List<AllowedDestination>> serviceability = map.getOrDefault(product, new HashMap<>());
        List<AllowedDestination> allowedDestinations = serviceability.getOrDefault(source, new ArrayList<>());
        allowedDestinations.add(new AllowedDestination(destination, mode));
        serviceability.put(source, allowedDestinations);
        map.put(product, serviceability);
    }
}
