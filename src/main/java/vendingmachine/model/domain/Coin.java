package vendingmachine.model.domain;

import static vendingmachine.constant.ErrorMessage.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
        return Arrays.stream(Coin.values())
            .map(Coin::getAmount)
            .collect(Collectors.toList());
    }

    public static Coin from(int amount) {
        return Arrays.stream(values())
            .filter(coin -> coin.getAmount() == amount)
            .findAny()
            .orElseThrow(() -> new IllegalArgumentException(INVALID_COIN_MONEY.getMessage()));
    }
}
