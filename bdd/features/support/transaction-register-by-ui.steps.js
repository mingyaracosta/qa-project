const {Given, When, Then} = require('cucumber');
const {expect} = require('chai');
const {Builder, By} = require('selenium-webdriver');

let chromeDriver = undefined;

Given('The following data transactionAmount: {float}', function (transactionAmount) {
    this.transactionAmount = transactionAmount;
});

When('I browse to the main page', {timeout: 15000}, async function () {
    chromeDriver = await new Builder().forBrowser('chrome').build();
    await chromeDriver.get('http://localhost:7878');
});

When('I fill the transaction amount input', async function () {
    await chromeDriver.findElement(By.id('amount-input')).sendKeys(this.transactionAmount);
});

When('I click in the submit button', async function () {
    await chromeDriver.findElement(By.id('submit-button')).click();
});

Then('I\'m shown {float} as the last transaction registered', async function (transactionAmount) {
    let lastTransactionAmount = undefined;
    await chromeDriver.findElement(By.id('last-transaction-amount-label'))
        .getText().then(function (labelText) {
            lastTransactionAmount = parseFloat(labelText);
        });

    expect(transactionAmount).to.eql(lastTransactionAmount);
    await chromeDriver.quit();
});

