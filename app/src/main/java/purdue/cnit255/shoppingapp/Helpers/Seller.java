package purdue.cnit255.shoppingapp.Helpers;

import java.util.UUID;

public class Seller {
    private String id;
    private String businessName;
    private long phoneNumber;
    private String email;
    private Address address;
    private Card bankAccount;

    //TODO: Change to Products
    private Cart cart;
    private Wishlist wishlist;

    public Seller(String businessName) {
        this.id = UUID.randomUUID().toString();
        this.businessName = businessName;
    }

    public Seller(String businessName, long phoneNumber, String email, Address address) {
        this.id = UUID.randomUUID().toString();
        this.businessName = businessName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Card getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(Card bankAccount) {
        this.bankAccount = bankAccount;
    }
}
