package vendingmachine.controller;

import vendingmachine.model.domain.Coins;
import vendingmachine.util.RandomUtil;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
    public void start() {
        OutputView.promptMachineHave();
        int money = InputView.vendingMachineHave();
        Coins vendingMahchineCoins = RandomUtil.createRandomCoins(money);
    }
}
