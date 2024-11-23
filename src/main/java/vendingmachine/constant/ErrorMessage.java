package vendingmachine.constant;

public enum ErrorMessage {
    INVALID_COIN_MONEY("[ERROR] 유효하지 않은 동전 금액입니다."),
    INVALID_PRODUCT_NAME("[ERROR] 상품명은 비어 있을 수 없습니다."),
    INVALID_PRODUCT_PRICE("[ERROR] 상품 가격은 100원부터 시작하며 10원으로 나누어 떨어져야 합니다."),
    INVALID_PRODUCT_QUANTITY("[ERROR] 상품 수량은 0 이상이어야 합니다."),
    PRODUCT_SOLD_OUT("[ERROR] 해당 상품은 품절되었습니다."),
    PRODUCT_IS_NOT_EXIST("[ERROR] 해당 상품이 존재하지 않습니다."),
    NOT_ENOUGH_MONEY("[ERROR] 구매 가능한 상품이 없습니다."),
    MONEY_SHOULD_BE_NUMBER("[ERROR] 금액은 숫자여야 합니다."),
    MONEY_SHOULD_BE_POSITIVE("[ERROR] 금액은 양수여야 합니다."),
    INVALID_PRODUCT_FORMAT("[ERROR] 상품의 형식이 올바르지 않습니다."),
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
