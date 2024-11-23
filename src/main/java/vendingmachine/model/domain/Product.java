package vendingmachine.model.domain;

public class Product {
    private final String productName;
    private final int price;
    private final int quantity;

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
            throw new IllegalArgumentException("[ERROR] 상품명은 비어 있을 수 없습니다.");
        }
    }

    private void validatePrice(int price) {
        if (price < 100 || price % 10 != 0) {
            throw new IllegalArgumentException("[ERROR] 상품 가격은 100원부터 시작하며 10원으로 나누어 떨어져야 합니다.");
        }
    }

    private void validateQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("[ERROR] 상품 수량은 0 이상이어야 합니다.");
        }
    }
}
