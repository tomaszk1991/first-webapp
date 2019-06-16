package pl.sda.kubik.servlet.domain;

import java.util.Objects;

public class Order {
    private final Cart cart;
    private final double totalPrice;
    private final Adress adress;
    private final User user;
    private String locale;


    public Order(final Cart cart, final Adress adress, final User user, final String locale) {
        this.cart = cart;
        this.adress = adress;
        this.totalPrice = cart.getTotalPrice();
        this.user = user;
        this.locale = locale;
    }

    public String getLocale() {
        return this.locale;
    }

    public void setLocale(final String locale) {
        this.locale = locale;
    }

    public Cart getCart() {
        return this.cart;
    }

    public double getTotalPrice() {
        return this.totalPrice;
    }

    public Adress getAdress() {
        return this.adress;
    }

    public User getUser() {
        return this.user;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final Order order = (Order) o;
        return Objects.equals(this.cart, order.cart) &&
                Objects.equals(this.totalPrice, order.totalPrice) &&
                Objects.equals(this.adress, order.adress) &&
                Objects.equals(this.user, order.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.cart, this.totalPrice, this.adress, this.user);
    }

    @Override
    public String toString() {
        return "Order{" +
                "cart=" + this.cart +
                ", totalPrice=" + this.totalPrice +
                ", adress=" + this.adress +
                ", user=" + this.user.getLogin() +
                '}';
    }
}
