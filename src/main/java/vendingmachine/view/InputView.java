package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.model.domain.Products;
import vendingmachine.util.Parser;

public class InputView {
    public static int vendingMachineHave() {
        String money = Console.readLine();
        return Integer.parseInt(money);
    }

    public static Products buyProducts() {
        String products = Console.readLine();
        return Parser.parseProducts(products);
    }

    public static int inputMoney() {
        String money = Console.readLine();
        return Integer.parseInt(money);
    }
}
