package vendingmachine.model.domain;

import java.util.EnumMap;
import java.util.Map;

public class Coins {
    private final Map<Coin, Integer> coins = new EnumMap<>(Coin.class);

    public int calculateTotalCoinAmount() {
        int totalCoinAmount = 0;
        for (Map.Entry<Coin, Integer> entry : coins.entrySet()) {
            Coin coin = entry.getKey();
            int coinCount = entry.getValue();
            totalCoinAmount += coin.getAmount() * coinCount;
        }
        return totalCoinAmount;
    }

    public void addCoin(Coin coin) {
        coins.put(coin, coins.getOrDefault(coin, 0) + 1);
    }

    public Map<Coin, Integer> getAllCoins() {
        return new EnumMap<>(coins);
    }

    public Coins calculateChange(int amount) {
        Coins change = new Coins();

        for (Coin coin : Coin.values()) {
            int coinAmount = coin.getAmount();
            int coinCount = coins.getOrDefault(coin, 0);

            int neededCoins = amount / coinAmount;
            int usedCoins = Math.min(neededCoins, coinCount);

            if (usedCoins > 0) {
                change.addMultipleCoins(coin, usedCoins);
                coins.put(coin, coinCount - usedCoins);
                amount -= coinAmount * usedCoins;
            }
        }
        return change;
    }

    public void addMultipleCoins(Coin coin, int count) {
        coins.put(coin, coins.getOrDefault(coin, 0) + count);
    }
}
