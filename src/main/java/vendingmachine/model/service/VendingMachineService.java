package vendingmachine.model.service;

import vendingmachine.model.domain.Coins;
import vendingmachine.model.domain.VendingMachine;
import vendingmachine.util.RandomUtil;

public class VendingMachineService {
    public VendingMachine getVendingMachine(int money) {
        Coins vendingMahchineCoins = RandomUtil.createRandomCoins(money);
        return new VendingMachine(vendingMahchineCoins);
    }
}
