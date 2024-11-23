package vendingmachine.model.domain;

import static vendingmachine.constant.ErrorMessage.INVALID_PRODUCT_NAME;
import static vendingmachine.constant.ErrorMessage.INVALID_PRODUCT_PRICE;
import static vendingmachine.constant.ErrorMessage.INVALID_PRODUCT_QUANTITY;
import static vendingmachine.constant.ErrorMessage.PRODUCT_SOLD_OUT;
import static vendingmachine.constant.NumberConstant.*;

public class Product {
    private final String productName;
    private final int price;
    private int quantity;

    public Product(String productName, int price, int quantity) {
        validateProductName(productName);
        validatePrice(price);
        validateQuantity(quantity);
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    private void validateProductName(String productName) {
        if (productName == null || productName.isEmpty()) {
            throw new IllegalArgumentException(INVALID_PRODUCT_NAME.getMessage());
        }
    }

    private void validatePrice(int price) {
        if (price < MINIMUM_MONEY_PRICE || price % DIVIDE_MONEY_UNIT != 0) {
            throw new IllegalArgumentException(INVALID_PRODUCT_PRICE.getMessage());
        }
    }

    private void validateQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException(INVALID_PRODUCT_QUANTITY.getMessage());
        }
    }

    public int getPrice() {
        return price;
    }

    public boolean isNameSame(String inputProductName) {
        return this.productName.equals(inputProductName);
    }

    public boolean isQuantityZero() {
        return this.quantity == 0;
    }

    public void decreaseQuantity() {
        if (quantity <= 0) {
            throw new IllegalArgumentException(PRODUCT_SOLD_OUT.getMessage());
        }
        this.quantity -= 1;
    }
}
