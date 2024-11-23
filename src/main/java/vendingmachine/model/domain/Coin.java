package vendingmachine.model.domain;

import java.util.ArrayList;
import java.util.List;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public static List<Integer> getAmounts() {
        List<Integer> amounts = new ArrayList<>();
        for (Coin coin : Coin.values()) {
            amounts.add(coin.amount);
        }
        return amounts;
    }

    public static Coin from(int amount) {
        for (Coin coin : values()) {
            if (coin.getAmount() == amount) {
                return coin;
            }
        }
        throw new IllegalArgumentException("[ERROR] 유효하지 않은 동전 금액입니다.");
    }
}