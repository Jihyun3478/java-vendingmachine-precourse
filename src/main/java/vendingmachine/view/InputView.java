package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.model.domain.Products;
import vendingmachine.util.Parser;

public class InputView {
    public static int vendingMachineHave() {
        while (true) {
            try {
                String money = Console.readLine();
                return Parser.parseInteger(money);
            } catch (IllegalArgumentException e) {
                OutputView.promptErrorMessage(e.getMessage());
            }
        }
    }

    public static Products buyProducts() {
        while (true) {
            try {
                String products = Console.readLine();
                return Parser.parseProducts(products);
            } catch (IllegalArgumentException e) {
                OutputView.promptErrorMessage(e.getMessage());
            }
        }
    }

    public static int inputMoney() {
        while (true) {
            try {
                String money = Console.readLine();
                return Parser.parseInteger(money);
            } catch (IllegalArgumentException e) {
                OutputView.promptErrorMessage(e.getMessage());
            }
        }
    }

    public static String buyProduct() {
        return Console.readLine();
    }
}
