package vendingmachine.model.domain;

public class VendingMachine {
    private final Coins coins;

    public VendingMachine(Coins coins) {
        this.coins = coins;
    }

    public Coins getCoins() {
        return coins;
    }
}
