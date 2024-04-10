import { test, expect } from '@playwright/test';

const heroName = 'Hero ' + Math.random().toString(16).substring(2);
const anotherHeroName = 'Hero ' + Math.random().toString(16).substring(2);

test('Open start page', async ({ page }) => {
  await page.goto('/');

  await expect(page).toHaveTitle(/Tour of Heroes/);
});

test('Add hero to list', async ({ page }) => {
  await page.goto('/heroes');

  const newTodo = await page.waitForSelector('#heroName');
  await newTodo.fill(heroName);
  await newTodo.press('Enter');

  // wait for list to be updated
  await page.getByRole('cell', { name: heroName }).waitFor({ state: 'visible' });

  await expect(page.getByRole('cell', { name: heroName })).toBeVisible();
});

test('Edit hero name', async ({ page }) => {
  await page.goto('/heroes');

  // Click on edit button
  await page.getByRole('row', { name: heroName }).getByLabel('View details').click();

  await page.locator('#heroName').fill(anotherHeroName);
  await page.getByRole('button', { name: 'Save' }).click();

  // wait for list to be updated
  await page.getByRole('cell', { name: anotherHeroName }).waitFor({ state: 'visible' });

  await expect(page.getByRole('cell', { name: anotherHeroName })).toBeVisible();
});

test('Remove hero from list', async ({ page }) => {
  await page.goto('/heroes');

  await page
    .getByRole('row')
    .filter({ hasText: anotherHeroName })
    .getByLabel('Delete Hero')
    .click();

  await expect(page.getByRole('cell', { name: anotherHeroName })).not.toBeVisible();
});
