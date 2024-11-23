package vendingmachine.model.domain;

import java.util.HashMap;
import java.util.Map;

import vendingmachine.Coin;

public class Coins {
    private final Map<Coin, Integer> coins = new HashMap<>();

    public int calculateTotalCoinAmount() {
        int totalCoinAmount = 0;
        for(Map.Entry<Coin, Integer> entry : coins.entrySet()) {
            Coin coin = entry.getKey();
            int coinCount = entry.getValue();
            totalCoinAmount += coin.getAmount() * coinCount;
        }
        return totalCoinAmount;
    }

    public void addCoin(Coin coin) {
        coins.put(coin, coins.getOrDefault(coin, 0) + 1);
    }
}
