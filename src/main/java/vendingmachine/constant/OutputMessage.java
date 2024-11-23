package vendingmachine.constant;

public enum OutputMessage {
    INPUT_MACHINE_HAVE("자판기가 보유하고 있는 금액을 입력해 주세요."),
    MACHINE_HAVE("\n자판기가 보유한 동전"),
    INPUT_PRODUCTS("\n상품명과 가격, 수량을 입력해 주세요."),
    INPUT_MONEY("\n투입 금액을 입력해 주세요."),
    BUYING("\n투입 금액: %d원%n구매할 상품명을 입력해주세요."),
    RETURN_CHANGE("\n잔돈 반환:"),
    ;

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String format(Object... args) {
        return String.format(this.message, args);
    }
}
