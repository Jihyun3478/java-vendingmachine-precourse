package vendingmachine.controller;

import vendingmachine.model.domain.Coins;
import vendingmachine.model.domain.VendingMachine;
import vendingmachine.util.RandomUtil;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
    public void start() {
        OutputView.promptInputMachineHave();
        int money = InputView.vendingMachineHave();

        VendingMachine vendingMachineCoins = getVendingMachine(money);
        OutputView.promptMachineHave(vendingMachineCoins);
    }

    private static VendingMachine getVendingMachine(int money) {
        Coins vendingMahchineCoins = RandomUtil.createRandomCoins(money);
        return new VendingMachine(vendingMahchineCoins);
    }
}
