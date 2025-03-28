package models;

public class Buyer {
    String buyerId;
    String buyerName;
    String buyerAddress;
    String buyerEmail;

    public Buyer(String buyerId, String buyerName, String buyerAddress, String buyerEmail, String pincode) {
        this.buyerId = buyerId;
        this.buyerName = buyerName;
        this.buyerAddress = buyerAddress;
        this.buyerEmail = buyerEmail;
        this.pincode = pincode;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    String pincode;

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getBuyerAddress() {
        return buyerAddress;
    }

    public void setBuyerAddress(String buyerAddress) {
        this.buyerAddress = buyerAddress;
    }

    public String getBuyerEmail() {
        return buyerEmail;
    }

    public void setBuyerEmail(String buyerEmail) {
        this.buyerEmail = buyerEmail;
    }

    public Buyer(String buyerId, String buyerName, String buyerAddress, String buyerEmail) {
        this.buyerId = buyerId;
        this.buyerName = buyerName;
        this.buyerAddress = buyerAddress;
        this.buyerEmail = buyerEmail;
    }


}
