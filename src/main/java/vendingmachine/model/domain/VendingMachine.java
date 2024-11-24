package vendingmachine.model.domain;

public class VendingMachine {
    private final Coins coins;
    private Products products;

    public VendingMachine(Coins coins) {
        this.coins = coins;
    }

    public Coins getCoins() {
        return coins;
    }

    public void addProducts(Products products) {
        this.products = products;
    }

    public int findProductPrice(String buyProductName) {
        return products.findPriceByProductName(buyProductName);
    }

    public int findMinimumProductPrice() {
        return products.findMinimumPrice();
    }

    public boolean areProductsSoldOut() {
        return products.areSoldOut();
    }

    public void purchaseProduct(String buyProductName) {
        products.decreaseProductQuantity(buyProductName);
    }

    public Coins returnChange(int amount) {
        return coins.calculateChange(amount);
    }
}
