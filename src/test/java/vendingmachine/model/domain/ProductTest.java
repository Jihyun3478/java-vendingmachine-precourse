package vendingmachine.model.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProductTest {
    @Test
    @DisplayName("상품 가격이 100원부터 시작하지 않는 경우 예외가 발생한다.")
    void 상품_가격이_100원부터_시작하지_않는_경우_예외_발생() {
        assertThatThrownBy(() -> new Product("콜라", 90, 1))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("상품 가격이 10원으로 나누어 떨어지지지 않는 경우 예외가 발생한다.")
    void 상품_가격이_10원으로_나누어_떨어지지_않는_경우_예외_발생() {
        assertThatThrownBy(() -> new Product("콜라", 9, 1))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("상품명이 비어있는 경 예외가 발생한다.")
    void 상품명이_비어있는_경우_예외_발생() {
        assertThatThrownBy(() -> new Product("", 1000, 1))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("상품 수량이 0 미만인 경우 예외가 발생한다.")
    void 상품_수량이_0_미만인_경우_예외_발생() {
        assertThatThrownBy(() -> new Product("콜라", 1000, -1))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
