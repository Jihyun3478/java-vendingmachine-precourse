package vendingmachine.view;

import vendingmachine.Coin;
import vendingmachine.model.domain.VendingMachine;

public class OutputView {
    public static void promptInputMachineHave() {
        System.out.println("자판기가 보유하고 있는 금액을 입력해 주세요.");
    }

    public static void promptMachineHave(VendingMachine vendingMachineCoins) {
        System.out.println("\n자판기가 보유한 동전");
        for (Coin coin : Coin.values()) {
            int coinCount = vendingMachineCoins.getCoins().getAllCoins().getOrDefault(coin, 0);
            System.out.printf("%d원 - %d개%n", coin.getAmount(), coinCount);
        }
    }

    public static void promptInputProducts() {
        System.out.println("\n상품명과 가격, 수량을 입력해 주세요.");
    }

    public static void promptInputMoney() {
        System.out.println("\n투입 금액을 입력해 주세요.");
    }
}
