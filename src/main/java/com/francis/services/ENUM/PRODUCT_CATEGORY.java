package com.francis.services.ENUM;

public enum PRODUCT_CATEGORY {

    ALCOHOLIC_DRINKS("Alcoholic drinks"),
    NON_ALCOHOLIC_DRINKS("Non Alcoholic Drinks"),
    COSMETICS("Cosmetics"),
    BEVERAGES("Beverages"),
    SEAFOODS("Sea Foods"),
    BAKERIES("Bakeries");

    private final String categoryName;

    PRODUCT_CATEGORY(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    @Override
    public String toString() {
        return "ProductCategory{" +
                "categoryName='" + categoryName + '\'' +
                '}';
    }
}
