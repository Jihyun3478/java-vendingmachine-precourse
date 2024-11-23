package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static int vendingMachineHave() {
        String money = Console.readLine();
        return Integer.parseInt(money);
    }
}
