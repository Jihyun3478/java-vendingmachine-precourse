package vendingmachine.util;

import static vendingmachine.constant.ErrorMessage.MONEY_SHOULD_BE_NUMBER;
import static vendingmachine.constant.ErrorMessage.MONEY_SHOULD_BE_POSITIVE;
import static vendingmachine.constant.ErrorMessage.INVALID_PRODUCT_FORMAT;
import static vendingmachine.constant.NumberConstant.*;

import java.util.ArrayList;
import java.util.List;

import vendingmachine.model.domain.Product;
import vendingmachine.model.domain.Products;

public class Parser {
    private static final String SEMICOLON = ";";
    private static final String LEFT_BRACKET = "[";
    private static final String RIGHT_BRACKET = "]";
    private static final String COMMA = ",";

    public static int parseInteger(String input) {
        try {
            int money = Integer.parseInt(input);
            validateNegative(money);
            return money;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(MONEY_SHOULD_BE_NUMBER.getMessage());
        }
    }

    private static void validateNegative(int money) {
        if(money < 0) {
            throw new IllegalArgumentException(MONEY_SHOULD_BE_POSITIVE.getMessage());
        }
    }

    public static Products parseProducts(String inputProducts) {
        List<Product> products = parseProductList(inputProducts);
        return new Products(products);
    }

    private static List<Product> parseProductList(String inputProducts) {
        String[] splitProducts = inputProducts.split(SEMICOLON);
        List<Product> products = new ArrayList<>();

        for (String splitProduct : splitProducts) {
            validateProductFormat(splitProduct);
            Product product = parseProduct(splitProduct);
            products.add(product);
        }
        return products;
    }

    private static void validateProductFormat(String productInfo) {
        if (!productInfo.startsWith(LEFT_BRACKET) || !productInfo.endsWith(RIGHT_BRACKET)) {
            throw new IllegalArgumentException(INVALID_PRODUCT_FORMAT.getMessage());
        }
    }

    private static Product parseProduct(String productInfo) {
        String content = productInfo.substring(1, productInfo.length() - 1);
        String[] splitProductInfo = content.split(COMMA);

        if (splitProductInfo.length != PRODUCTS_LENGTH) {
            throw new IllegalArgumentException(INVALID_PRODUCT_FORMAT.getMessage());
        }

        String name = splitProductInfo[0].trim();
        int price = Integer.parseInt(splitProductInfo[1].trim());
        int quantity = Integer.parseInt(splitProductInfo[2].trim());

        return new Product(name, price, quantity);
    }
}
