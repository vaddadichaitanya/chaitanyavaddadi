package com.newfold.ecommerce.utils;

public class TestDataProvider {
    public static Object[][] getTestData() {
        return ExcelUtils.getTestData("src/test/resources/data/testdata.xlsx", "LoginData");
    }
}
