import { setWorldConstructor, World } from '@cucumber/cucumber';
import { Browser, BrowserContext, Page, chromium } from '@playwright/test';

export class CustomWorld extends World {
  browser: Browser | null = null;
  context: BrowserContext | null = null;
  page: Page | null = null;
}

setWorldConstructor(CustomWorld);
