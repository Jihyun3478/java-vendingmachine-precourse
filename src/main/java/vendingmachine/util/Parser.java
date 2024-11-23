package vendingmachine.util;

import vendingmachine.model.domain.Product;
import vendingmachine.model.domain.Products;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    public static Products parseProducts(String inputProducts) {
        List<Product> products = parseProductList(inputProducts);
        return new Products(products);
    }

    private static List<Product> parseProductList(String inputProducts) {
        String[] splitProducts = inputProducts.split(";");
        List<Product> products = new ArrayList<>();

        for (String splitProduct : splitProducts) {
            validateProductFormat(splitProduct);
            Product product = parseProduct(splitProduct);
            products.add(product);
        }
        return products;
    }

    private static void validateProductFormat(String productInfo) {
        if (!productInfo.startsWith("[") || !productInfo.endsWith("]")) {
            throw new IllegalArgumentException("[ERROR] 개별 상품은 대괄호([])로 감싸져 있어야 합니다.");
        }
    }

    private static Product parseProduct(String productInfo) {
        String content = productInfo.substring(1, productInfo.length() - 1);
        String[] splitProductInfo = content.split(",");

        if (splitProductInfo.length != 3) {
            throw new IllegalArgumentException("[ERROR] 상품명, 가격, 수량은 쉼표(,)로 구분되어야 합니다.");
        }

        String name = splitProductInfo[0].trim();
        int price = Integer.parseInt(splitProductInfo[1].trim());
        int quantity = Integer.parseInt(splitProductInfo[2].trim());

        return new Product(name, price, quantity);
    }
}
