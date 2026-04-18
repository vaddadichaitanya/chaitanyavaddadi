package com.newfold.ecommerce.tests;
import org.testng.annotations.Test;

public class CheckoutTest {
    @Test(dataProvider = "checkoutData")
    public void testEndToEndCheckout(String product, String paymentMethod) {
        // Data-driven hybrid testing implementation
    }
}
