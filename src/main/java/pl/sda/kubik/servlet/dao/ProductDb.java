package pl.sda.kubik.servlet.dao;

import pl.sda.kubik.servlet.domain.Product;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class ProductDb {

    private static ProductDb instance = null;
    private final List<Product> allProducts;


    private ProductDb() {

        this.allProducts = new LinkedList<>();
        this.allProducts.add(new Product(0L, "Supercolider",
                "After you attack a minion, force it to attack one of its neighbors.", 5, "https://gamepedia.cursecdn.com/hearthstone_gamepedia/thumb/b/bb/Supercollider%2889811%29.png/200px-Supercollider%2889811%29.png?version=bc3313f1d6a6b074897fd63c8e14a6fb", "Warrior"));
        this.allProducts.add(new Product(1L, "Bloodclaw",
                "Battlecry: Deal 5 damage to your hero.", 1, "https://gamepedia.cursecdn.com/hearthstone_gamepedia/thumb/8/8a/Bloodclaw%2890265%29.png/200px-Bloodclaw%2890265%29.png?version=1f2eda912f8a00de3a926ddafedcb9fc", "Paladin"));
        this.allProducts.add(new Product(2L, "Headhunter's Hatchet",
                "Battlecry: If you control a Beast, gain +1 Durability.", 2, "https://gamepedia.cursecdn.com/hearthstone_gamepedia/thumb/b/bd/Headhunter%27s_Hatchet%2890281%29.png/200px-Headhunter%27s_Hatchet%2890281%29.png?version=678c8ef0f76fd445b8bea07aee5676bf", "Hunter"));
    }

    public static ProductDb getInstance() {
        if (ProductDb.instance == null) {
            ProductDb.instance = new ProductDb();
        }

        return ProductDb.instance;
    }


    public List<Product> getAllProducts() {
        return this.allProducts;
    }


    public Optional<Product> getProductByID(final long id) {

//        for (Product allProduct : allProducts) {
//            if (allProduct.getId() == id) return Optional.of(allProduct);
//        }
//
//        return null;
        return this.allProducts.stream().filter(x -> x.getId() == id).findFirst();
    }

    public long createNewProduct(final String name, final String description, final long price, final String image, final List<String> categories) {


        final long id = this.allProducts.size() + 1;

        this.allProducts.add(new Product(id, name, description, price, image, categories));
        return id;

    }

    public long createNewProduct(final String name, final String description, final long price, final String image, final String... categories) {


        final long id = this.allProducts.size() + 1;

        this.allProducts.add(new Product(id, name, description, price, image, categories));
        return id;

    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(final Object obj) {
        return super.equals(obj);
    }
}
