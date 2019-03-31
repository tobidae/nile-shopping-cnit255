package purdue.cnit255.shoppingapp.Helpers;

public class Customer extends User {
    private Card paymentCard;
    private Cart cart;
    private Wishlist wishlist;

    public Customer(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Customer(String id, String firstName, String lastName) {
        super(id, firstName, lastName);
    }

    public Customer(String id, String firstName, String lastName, int phoneNumber, String email, String address) {
        super(id, firstName, lastName, phoneNumber, email, address);
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
