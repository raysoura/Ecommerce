package service.impl;

import constants.PaymentMode;
import repository.PincodeServiceabilityRepository;
import service.PincodeServiceability;


public class PincodeServiceabilityServiceImpl implements PincodeServiceability {
    private final PincodeServiceabilityRepository pincodeServiceabilityRepository;

    public PincodeServiceabilityServiceImpl(PincodeServiceabilityRepository pincodeServiceabilityRepository) {
        this.pincodeServiceabilityRepository = pincodeServiceabilityRepository;
    }

    @Override
    public boolean checkServiceability(String product, String source, String destination, PaymentMode mode) {
        return pincodeServiceabilityRepository.checkServiceability(product, source, destination, mode);
    }

    @Override
    public void addServiceability(String product, String source, String destination, PaymentMode mode) {
        pincodeServiceabilityRepository.addServiceability(product, source, destination, mode);
    }
}
