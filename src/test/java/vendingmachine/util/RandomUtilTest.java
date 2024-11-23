package vendingmachine.util;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import vendingmachine.model.domain.Coins;

public class RandomUtilTest {
    @Test
    @DisplayName("자판기가 보유하고 있는 금액만큼 동전을 무작위로 생성한다.")
    void 자판기_동전_무작위_생성() {
        Coins vendingMahchineCoins = RandomUtil.createRandomCoins(450);
        assertThat(vendingMahchineCoins.calculateTotalCoinAmount()).isEqualTo(450);
    }
}
