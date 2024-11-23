package vendingmachine.model.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import vendingmachine.Coin;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class VendingMachineTest {

    private VendingMachine vendingMachine;

    @BeforeEach
    void setUp() {
        Coins coins = new Coins();
        coins.addMultipleCoins(Coin.COIN_500, 2);
        coins.addMultipleCoins(Coin.COIN_100, 5);
        coins.addMultipleCoins(Coin.COIN_50, 3);
        coins.addMultipleCoins(Coin.COIN_10, 10);

        vendingMachine = new VendingMachine(coins);
    }

    @Test
    @DisplayName("잔돈이 정상적으로 반환되는지 확인한다.")
    void 잔돈_반환_확인() {
        int returnMoney = 870;

        Coins change = vendingMachine.returnChange(returnMoney);

        Map<Coin, Integer> changeMap = change.getAllCoins();
        assertThat(changeMap.get(Coin.COIN_500)).isEqualTo(1);
        assertThat(changeMap.get(Coin.COIN_100)).isEqualTo(3);
        assertThat(changeMap.get(Coin.COIN_50)).isEqualTo(1);
        assertThat(changeMap.get(Coin.COIN_10)).isEqualTo(2);

        Map<Coin, Integer> remainingCoins = vendingMachine.getCoins().getAllCoins();
        assertThat(remainingCoins.get(Coin.COIN_500)).isEqualTo(1);
        assertThat(remainingCoins.get(Coin.COIN_100)).isEqualTo(2);
        assertThat(remainingCoins.get(Coin.COIN_50)).isEqualTo(2);
        assertThat(remainingCoins.get(Coin.COIN_10)).isEqualTo(8);
    }

    @Test
    @DisplayName("잔돈을 반환할 수 없는 경우 잔돈으로 반환할 수 있는 금액만 반환한다.")
    void 반환할_잔돈이_부족하면_가능한_금액만_반환() {
        int returnMoney = 3000;

        Coins change = vendingMachine.returnChange(returnMoney);

        Map<Coin, Integer> changeMap = change.getAllCoins();
        assertThat(changeMap.get(Coin.COIN_500)).isEqualTo(2);
        assertThat(changeMap.get(Coin.COIN_100)).isEqualTo(5);
        assertThat(changeMap.get(Coin.COIN_50)).isEqualTo(3);
        assertThat(changeMap.get(Coin.COIN_10)).isEqualTo(10);

        Map<Coin, Integer> remainingCoins = vendingMachine.getCoins().getAllCoins();
        assertThat(remainingCoins.get(Coin.COIN_500)).isEqualTo(0);
        assertThat(remainingCoins.get(Coin.COIN_100)).isEqualTo(0);
        assertThat(remainingCoins.get(Coin.COIN_50)).isEqualTo(0);
        assertThat(remainingCoins.get(Coin.COIN_10)).isEqualTo(0);
    }
}
