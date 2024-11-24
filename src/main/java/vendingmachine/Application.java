package vendingmachine;

import vendingmachine.controller.VendingMachineController;
import vendingmachine.model.service.VendingMachineService;

public class Application {
    public static void main(String[] args) {
        VendingMachineController vendingMachineController = new VendingMachineController(new VendingMachineService());
        vendingMachineController.start();
    }
}
