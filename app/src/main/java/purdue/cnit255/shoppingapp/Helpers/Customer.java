package purdue.cnit255.shoppingapp.Helpers;

public class Customer extends User {
    private Card paymentCard;
    private Cart cart;
    private Wishlist wishlist;

    public Customer(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Customer(String firstName, String lastName, long phoneNumber, String email, Address address) {
        super(firstName, lastName, phoneNumber, email, address);
    }

    public Card getPaymentCard() {
        return paymentCard;
    }

    public void setPaymentCard(Card paymentCard) {
        this.paymentCard = paymentCard;
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
