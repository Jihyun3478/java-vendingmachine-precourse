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
}
