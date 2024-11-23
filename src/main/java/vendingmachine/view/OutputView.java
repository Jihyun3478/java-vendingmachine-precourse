package vendingmachine.view;

import vendingmachine.constant.OutputMessage;
import vendingmachine.model.domain.Coin;
import vendingmachine.model.domain.Coins;
import vendingmachine.model.domain.VendingMachine;

public class OutputView {

    public static void promptInputMachineHave() {
        System.out.println(OutputMessage.INPUT_MACHINE_HAVE.format());
    }

    public static void promptMachineHave(VendingMachine vendingMachineCoins) {
        System.out.println(OutputMessage.MACHINE_HAVE.format());
        for (Coin coin : Coin.values()) {
            int coinCount = vendingMachineCoins.getCoins().getAllCoins().getOrDefault(coin, 0);
            System.out.printf("%d원 - %d개%n", coin.getAmount(), coinCount);
        }
    }

    public static void promptInputProducts() {
        System.out.println(OutputMessage.INPUT_PRODUCTS.format());
    }

    public static void promptInputMoney() {
        System.out.println(OutputMessage.INPUT_MONEY.format());
    }

    public static void promptBuying(int inputMoney) {
        System.out.println(OutputMessage.BUYING.format(inputMoney));
    }

    public static void promptReturnChange(Coins change) {
        System.out.println(OutputMessage.RETURN_CHANGE.format());
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
