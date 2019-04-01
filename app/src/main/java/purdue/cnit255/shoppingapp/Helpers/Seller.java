package purdue.cnit255.shoppingapp.Helpers;

public class Seller extends User {
    private Card bankAccount;
    private Cart cart;
    private Wishlist wishlist;

    public Seller(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Seller(String firstName, String lastName, long phoneNumber, String email, Address address) {
        super(firstName, lastName, phoneNumber, email, address);
    }

    public Card getPaymentCard() {
        return bankAccount;
    }

    public void setPaymentCard(Card bankAccount) {
        this.bankAccount = bankAccount;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Wishlist getWishlist() {
        return wishlist;
    }

    public void setWishlist(Wishlist wishlist) {
        this.wishlist = wishlist;
    }
}
