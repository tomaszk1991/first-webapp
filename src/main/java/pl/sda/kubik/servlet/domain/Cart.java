package pl.sda.kubik.servlet.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Cart {
    private final Map<Product, Integer> products;

    public Cart() {
        this.products = new HashMap<>();
    }

    public Map<Product, Integer> get() {

        return new HashMap<>(this.products);

    }

    public void update(final Product product, final Integer quantity) {

        final Integer oldQuantity = this.products.getOrDefault(product, 0);
        if (oldQuantity + quantity > 0) {
            this.products.put(product, oldQuantity + quantity);


        } else {
            this.products.remove(product);
        }


    }

    public double getTotalPrice() {

        double totalPirce = 0;
        for (final Map.Entry<Product, Integer> entry : this.products.entrySet()) {
            totalPirce += entry.getKey().getPrice() * entry.getValue();
        }

        return totalPirce;


    }

    public void clear() {
        this.products.clear();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final Cart cart = (Cart) o;
        return Objects.equals(this.products, cart.products);
    }

    @Override
    public String toString() {
        return "Cart{" +
                "products=" + this.products +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.products);

    }
}
