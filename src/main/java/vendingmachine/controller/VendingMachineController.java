package vendingmachine.controller;

import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
    public void start() {
        OutputView.promptMachineHave();
        InputView.vendingMachineHave();
    }
}
