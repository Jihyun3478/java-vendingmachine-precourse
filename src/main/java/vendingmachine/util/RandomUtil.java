package vendingmachine.util;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.Coin;
import vendingmachine.model.domain.Coins;

public class RandomUtil {
    public static Coins createRandomCoins(int money) {
        Coins coins = new Coins();

        while(money > 0) {
            int randomCoinAmount = Randoms.pickNumberInList(Coin.getAmounts());

            if(money >= randomCoinAmount) {
                money -= randomCoinAmount;
                coins.addCoin(Coin.from(randomCoinAmount));
            }
        }
        return coins;
    }
}
