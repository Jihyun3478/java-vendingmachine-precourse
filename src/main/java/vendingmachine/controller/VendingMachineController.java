package vendingmachine.controller;

import vendingmachine.model.domain.Coins;
import vendingmachine.model.domain.Products;
import vendingmachine.model.domain.VendingMachine;
import vendingmachine.util.RandomUtil;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
    public void start() {
        OutputView.promptInputMachineHave();
        int money = InputView.vendingMachineHave();

        VendingMachine vendingMachine = getVendingMachine(money);
        OutputView.promptMachineHave(vendingMachine);

        OutputView.promptInputProducts();
        Products products = InputView.buyProducts();
        vendingMachine.addProducts(products);

        OutputView.promptInputMoney();
        int inputMoney = InputView.inputMoney();

        while (inputMoney > 0) {
            int minPrice = vendingMachine.findMinimumProductPrice();
            if (inputMoney < minPrice) {
                break;
            }

            if (vendingMachine.areProductsSoldOut()) {
                break;
            }

            OutputView.promptBuying(inputMoney);
            String buyProductName = InputView.buyProduct();

            try {
                int productPrice = vendingMachine.findProductPrice(buyProductName);
                inputMoney -= productPrice;
                vendingMachine.purchaseProduct(buyProductName);
            } catch (IllegalArgumentException e) {
                OutputView.promptErrorMessage(e.getMessage());
            }
        }
        Coins change = vendingMachine.returnChange(inputMoney);
        OutputView.promptReturnChange(change);
    }

    private static VendingMachine getVendingMachine(int money) {
        Coins vendingMahchineCoins = RandomUtil.createRandomCoins(money);
        return new VendingMachine(vendingMahchineCoins);
    }
}
