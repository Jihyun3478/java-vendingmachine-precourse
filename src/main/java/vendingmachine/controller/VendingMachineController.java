package vendingmachine.controller;

import vendingmachine.model.domain.Coins;
import vendingmachine.model.domain.Products;
import vendingmachine.model.domain.VendingMachine;
import vendingmachine.model.service.VendingMachineService;
import vendingmachine.util.RandomUtil;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {
    private final VendingMachineService vendingMachineService;

    public VendingMachineController(VendingMachineService vendingMachineService) {
        this.vendingMachineService = vendingMachineService;
    }

    public void start() {
        OutputView.promptInputMachineHave();
        int money = InputView.vendingMachineHave();

        VendingMachine vendingMachine = vendingMachineService.getVendingMachine(money);
        OutputView.promptMachineHave(vendingMachine);

        getProducts(vendingMachine);
        int inputMoney = getInputMoney();

        inputMoney = getInputMoney(vendingMachine, inputMoney);
        getReturnChange(vendingMachine, inputMoney);
    }

    private static void getProducts(VendingMachine vendingMachine) {
        OutputView.promptInputProducts();
        Products products = InputView.buyProducts();
        vendingMachine.addProducts(products);
    }

    private static int getInputMoney() {
        OutputView.promptInputMoney();
        return InputView.inputMoney();
    }

    private static int getInputMoney(VendingMachine vendingMachine, int inputMoney) {
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

            inputMoney = calculateInputMoney(vendingMachine, inputMoney, buyProductName);
        }
        return inputMoney;
    }

    private static void getReturnChange(VendingMachine vendingMachine, int inputMoney) {
        Coins change = vendingMachine.returnChange(inputMoney);
        OutputView.promptReturnChange(change);
    }

    private static int calculateInputMoney(VendingMachine vendingMachine, int inputMoney, String buyProductName) {
        try {
            int productPrice = vendingMachine.findProductPrice(buyProductName);
            inputMoney -= productPrice;
            vendingMachine.purchaseProduct(buyProductName);
        } catch (IllegalArgumentException e) {
            OutputView.promptErrorMessage(e.getMessage());
        }
        return inputMoney;
    }
}
