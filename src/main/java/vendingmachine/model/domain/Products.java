package vendingmachine.model.domain;

import static vendingmachine.constant.ErrorMessage.PRODUCT_IS_NOT_EXIST;
import static vendingmachine.constant.ErrorMessage.NOT_ENOUGH_MONEY;

import java.util.List;

public class Products {
    private final List<Product> products;

    public Products(List<Product> products) {
        this.products = products;
    }

    public int findPriceByProductName(String productName) {
        return products.stream()
            .filter(product -> product.isNameSame(productName))
            .findAny()
            .orElseThrow(() -> new IllegalArgumentException(PRODUCT_IS_NOT_EXIST.getMessage()))
            .getPrice();
    }

    public int findMinimumPrice() {
        return products.stream()
            .filter(product -> !product.isQuantityZero())
            .mapToInt(Product::getPrice)
            .min()
            .orElseThrow(() -> new IllegalArgumentException(NOT_ENOUGH_MONEY.getMessage()));
    }

    public boolean areSoldOut() {
        return products.stream().allMatch(Product::isQuantityZero);
    }

    public void decreaseProductQuantity(String productName) {
        Product product = products.stream()
            .filter(name -> name.isNameSame(productName))
            .findAny()
            .orElseThrow(() -> new IllegalArgumentException(PRODUCT_IS_NOT_EXIST.getMessage()));

        product.decreaseQuantity();
    }
}
