package vendingmachine.view;

import vendingmachine.model.domain.Coin;
import vendingmachine.model.domain.Coins;
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

    public static void promptBuying(int inputMoney) {
        System.out.printf("\n투입 금액: %d원%n", inputMoney);
        System.out.println("구매할 상품명을 입력해주세요.");
    }

    public static void promptReturnChange(Coins change) {
        System.out.println("\n잔돈 반환:");
        for (Coin coin : Coin.values()) {
            int count = change.getAllCoins().getOrDefault(coin, 0);
            if (count > 0) {
                System.out.printf("%d원 - %d개%n", coin.getAmount(), count);
            }
        }
    }

    public static void promptErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
