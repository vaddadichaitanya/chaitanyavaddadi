import { Page } from '@playwright/test';

export class CheckoutPage {
    constructor(private page: Page) {}

    async login() {
        await this.page.goto('https://www.saucedemo.com/');
        await this.page.fill('[data-test="username"]', 'standard_user');
        await this.page.fill('[data-test="password"]', 'secret_sauce');
        await this.page.click('[data-test="login-button"]');
    }

    async addProductToCart() {
        await this.page.click('[data-test="add-to-cart-sauce-labs-backpack"]');
    }

    async goToCartAndCheckout() {
        await this.page.click('.shopping_cart_link');
        await this.page.click('[data-test="checkout"]');
    }

    async fillCheckoutInfo() {
        await this.page.fill('[data-test="firstName"]', 'John');
        await this.page.fill('[data-test="lastName"]', 'Doe');
        await this.page.fill('[data-test="postalCode"]', '12345');
        await this.page.click('[data-test="continue"]');
    }

    async finishPurchase() {
        await this.page.click('[data-test="finish"]');
    }

    async getCompletionMessage() {
        return await this.page.textContent('.complete-header');
    }
}
