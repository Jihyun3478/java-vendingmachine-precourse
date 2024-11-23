package vendingmachine.model.domain;

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
            .orElseThrow(() -> new IllegalArgumentException("[ERROR] 해당 상품이 존재하지 않습니다."))
            .getPrice();
    }

    public int findMinimumPrice() {
        return products.stream()
            .filter(product -> !product.isQuantityZero())
            .mapToInt(Product::getPrice)
            .min()
            .orElseThrow(() -> new IllegalArgumentException("[ERROR] 구매 가능한 상품이 없습니다."));
    }

    public boolean areSoldOut() {
        return products.stream().allMatch(Product::isQuantityZero);
    }

    public void decreaseProductQuantity(String productName) {
        Product product = products.stream()
            .filter(name -> name.isNameSame(productName))
            .findAny()
            .orElseThrow(() -> new IllegalArgumentException("[ERROR] 해당 상품이 존재하지 않습니다."));

        product.decreaseQuantity();
    }
}
