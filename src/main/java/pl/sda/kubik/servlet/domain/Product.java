package pl.sda.kubik.servlet.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Product {

    private long id;
    private String name;
    private String description;
    private List<String> categories;
    private double price;
    private String image;

    public Product(final long id, final String name, final String description, final double price, final String image, final List<String> categories) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.categories = categories;

        this.price = price;
        this.image = image;
    }

    public Product(final long id, final String name, final String description, final double price, final String image, final String... catogories) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.categories = Arrays.asList(catogories);

        this.price = price;
        this.image = image;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(final String image) {
        this.image = image;
    }

    public long getId() {
        return this.id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public List<String> getCategories() {
        return this.categories;
    }

    public void setCategories(final List<String> categories) {
        this.categories = categories;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(final double price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + this.id +
                ", name='" + this.name + '\'' +
                ", descriptionn='" + this.description + '\'' +
                ", categories=" + this.categories +
                ", price=" + this.price +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final Product product = (Product) o;
        return this.id == product.id &&
                this.price == product.price &&
                Objects.equals(this.name, product.name) &&
                Objects.equals(this.description, product.description) &&
                Objects.equals(this.categories, product.categories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.description, this.categories, this.price);
    }
}
