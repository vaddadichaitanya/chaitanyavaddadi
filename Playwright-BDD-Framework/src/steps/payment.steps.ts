import { Given, When, Then } from '@cucumber/cucumber';
import { expect } from '@playwright/test';
import { CustomWorld } from '../support/world';
import { CheckoutPage } from '../pages/CheckoutPage';

Given('I am on the saucedemo login page', async function(this: CustomWorld) {
    if (!this.page) throw new Error("Page is undefined");
    await this.page.goto('https://www.saucedemo.com/');
});

When('I login with standard_user and secret_sauce', async function(this: CustomWorld) {
    if (!this.page) throw new Error("Page is undefined");
    const checkoutPage = new CheckoutPage(this.page);
    await checkoutPage.login();
});

When('I add a product to the cart', async function(this: CustomWorld) {
    if (!this.page) throw new Error("Page is undefined");
    const checkoutPage = new CheckoutPage(this.page);
    await checkoutPage.addProductToCart();
});

When('I go to the cart and checkout', async function(this: CustomWorld) {
    if (!this.page) throw new Error("Page is undefined");
    const checkoutPage = new CheckoutPage(this.page);
    await checkoutPage.goToCartAndCheckout();
});

When('I fill in my checkout information', async function(this: CustomWorld) {
    if (!this.page) throw new Error("Page is undefined");
    const checkoutPage = new CheckoutPage(this.page);
    await checkoutPage.fillCheckoutInfo();
});

When('I complete the purchase', async function(this: CustomWorld) {
    if (!this.page) throw new Error("Page is undefined");
    const checkoutPage = new CheckoutPage(this.page);
    await checkoutPage.finishPurchase();
});

Then('I should see the checkout complete message', async function(this: CustomWorld) {
    if (!this.page) throw new Error("Page is undefined");
    const checkoutPage = new CheckoutPage(this.page);
    const message = await checkoutPage.getCompletionMessage();
    expect(message).toBe('Thank you for your order!');
});
